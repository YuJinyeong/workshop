package hong;
import java.util.Scanner;

public class SWEA1949등산로조성 {
	static int N;//맵의 크기
	static int K;//최대 깔 수 있는 땅깊이
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			int m = 0;
			//전체 맵을 입력받으면서 젤 높은 곳의 위치를 기억
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					m = Math.max(m, map[i][j]);
				}
			}
			max = 0;
			//젤 높은 곳에 해당하는 포인트들에서부터 dfs 시작
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++) {
					if( m == map[i][j] )
						dfs(i, j, false, 1, map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	
	static int max = 0;
	static void dfs(int r, int c, boolean isUsed, int cnt, int height) {
		//현재위치 방문체크.
		visited[r][c] = true;
//		현재 몇번왔는지 가 최대값이라면 기억.
		max = Math.max(max, cnt);
//		4방향에 대한 다음칸에 대해서.
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			지도 밖으로 나가는 것은 패스
			if( nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
//			방문한적이 있는 곳이면 패스
			if( visited[nr][nc] )
				continue;
//			현재높이보다 다음칸의 높이가 작다면
//			해당위치로 고고
			if( map[nr][nc] < height )
				dfs(nr, nc, isUsed, cnt + 1, map[nr][nc]);
//			현재높이보다 다음칸의 높이가 작지는 않지만 K만큰 깠을때 갈 수 있다면
//			해당위치의 높이를 현재보다 -1로 고고
			else if( !isUsed && map[nr][nc] - K < height )
				dfs(nr, nc, true, cnt + 1, height - 1);
		}
		//현재 위치 안온걸로 원복
		visited[r][c] = false;
	}
}