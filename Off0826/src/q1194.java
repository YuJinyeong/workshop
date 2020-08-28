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
		int key;
		
		Node(){}
		Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.key = cnt;
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
		int ans = 987654321;
		Queue<Node> qu = new LinkedList<>();
		check[start.r][start.c][start.key] = true;
		qu.add(start);
		int cnt = 1;
		while(!qu.isEmpty()) {
			Node n = qu.poll();
			int curKey = n.key;
			
			if(map[n.r][n.c] == '1') {
				ans = cnt;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				int nxtKey = curKey;
				
				if(nr<0 || nc<0 || nr>=N || nc>=M)
					continue;
				
				if(map[nr][nc] == '#')
					continue;
				
				else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					nxtKey = nxtKey|(1<<(map[nr][nc] - 'a'));
				}
				
				else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if((curKey&(1<<(map[nr][nc] - 'A'))) == 0)
						continue;
				}
				
				if(check[nr][nc][curKey]) continue;
				
				check[nr][nc][curKey] = true;
				qu.offer(new Node(nr, nc, (char)curKey));
			}
			cnt++;
		}
		if(ans == 987654321) ans = -1;
		System.out.println(ans);
	}

}
