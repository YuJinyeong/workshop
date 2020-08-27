import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Status{
		int r, c, cnt;
		boolean crush;
		public Status(int r, int c, int cnt, boolean crush) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.crush = crush;
		}
	}
	static int N,M;
	static int[][] map;
	//[0][0][0] 벽 안부순 상태로 0,0을 방문
	static boolean[][][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		Queue<Status> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.add(new Status(0, 0, 1, false));
		int ans = -1;
		while(!queue.isEmpty()) {
			Status s = queue.poll();
			if(s.r == N-1 && s.c == M-1) {
				ans = s.cnt;
				break;
			}
			//현위치로부터 4방에 대해서
			for(int d = 0; d < 4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				//밖으로 나간건 아웃
				if( nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				//같은 상태로 같은 위치에 방문한적이 있으면 패스
				if(visited[nr][nc][s.crush ? 1  : 0])
					continue;
				//벽 안깨고 갈 수 있는 곳
				if( map[nr][nc] == 0 ) {
					visited[nr][nc][s.crush ? 1  : 0] = true;
					queue.add(new Status(nr, nc, s.cnt + 1, s.crush));
				}
				//nr,nc가 벽이지만 내가 벽을 깨도 되는 경우
				if(map[nr][nc] == 1 && !s.crush) {
					visited[nr][nc][1] = true;//벽을 깬 상태의 방문을 체크
					queue.add(new Status(nr, nc, s.cnt+1, true));
				}
			}
		}
		System.out.println(ans);
	}
}









