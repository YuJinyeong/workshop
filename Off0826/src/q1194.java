import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1194 {
	static class Node{
		int r;
		int c;
		int cnt;
		
		Node(){}
		Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node start = null;
		char[][] map = new char[N][M];
		boolean[][][] check = new boolean[N][M][1<<6]; // 1<<6이 의미하는 바는 2의 6승....
		for(int i=0; i<N; i++) {
			String chars = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = chars.charAt(j);
				if(map[i][j] == '0') start = new Node(i, j, 0);
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = -1;
		Queue<Node> qu = new LinkedList<>();
		qu.add(start);
		while(!qu.isEmpty()) {
			Node n = qu.poll();
			
			if(map[n.r][n.c] == 1)
				ans = n.cnt;
			
			for(int d=0; d<4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M)
					continue;
				
				if(map[nr][nc] == '#')
					continue;
				
				else if(map[nr][nc] == '.') 
					qu.add(new Node(nr, nc, n.cnt+1));
				
				else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
					qu.add(new Node(nr, nc, n.cnt+1));
				}
				
				else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
					if(check[nr][nc][map[nr][nc] + 32 - 'a'])
						qu.add(new Node(nr, nc, n.cnt+1));
				}
			}
		}
		System.out.println(ans);
	}

}
