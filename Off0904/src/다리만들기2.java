import java.util.Scanner;

public class 다리만들기2 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				map[i][j] = sc.nextInt();
		}
		int idx = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1)
					dfs(i, j, idx++);
			}
		}
		int[][] adj = new int[idx-2][idx-2];
		// 모든 칸에 대해서 검사
		// 바다가 아니라면, 4방으로 뻗어보자. 밖으로 나가지 않으면서바다가 아닌 곳을 만날 때까지
		// 그떄까지 지나간 칸의 수와 만난 육지의 번호를 보고
		// adj[출발지][목적지] = 칸의 수
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						int cnt = 0;
						int start = map[i][j] - 2;
						int dest = 0;
						while(nr>=0 && nc>=0 && nr<N && nc<M) {
							if(map[nr][nc] != 0) {
								dest = map[nr][nc];
								break;
							}
							nr += dr[d];
							nc += dc[d];
							cnt++;
						}
						dest -= 2;
						if(dest != -2 && cnt > 1) {
							if(adj[start][dest]>0) {
								adj[start][dest] = Math.min(adj[start][dest], cnt);
								adj[dest][start] = adj[start][dest];
							}else {
								adj[start][dest] = cnt;
								adj[dest][start] = cnt;
							}
						}
					}
				}
				
			}
		}
		boolean[] visited = new boolean[idx-2];
		visited[0] = true;
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void dfs(int r, int c, int n) {
		map[r][c] = n;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nc>=0 &&)
		}
	}
}
