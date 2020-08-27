import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//가중치가 없는 그래프에서 최단 경로를 구할 때 : BFS가 유리
//가중치가 있으면 따져봐야 한다.
//알파벳이 장애물 역할을 하는데, 최장 26밖에 안된다.
//그리고, 어차피 최장을 구하는 거라 끝까지 다 해봐야 한다. 그래서 이 문제는 BFS로 푼다.

public class Solution1_7609_수지의수지맞는여행 {

	static int R, C, max;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			visited = new boolean[26];
			max = 0;
			for(int i=0; i<R; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			go(0, 0, 1);
			System.out.println("#" + t + " " + max);
		}
	}

	public static void go(int r, int c, int cnt) {
		
		visited[map[r][c] - 'A'] = true;
		if(max<cnt) max = cnt;
		if(max == 26) return;
		
		int nr, nc;
		for(int d=0; d<4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=R || nc>= C || visited[map[nr][nc]-'A']) continue;
			go(nr, nc, cnt+1);
		}
		visited[map[r][c] - 'A'] = false;
	}
}
