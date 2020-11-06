import java.util.Arrays;
import java.util.Scanner;

public class SWEA1828파핑파핑_dfs {
	static char[][] map; //입력되는 맵
	static int[][] cnt; //지뢰가 없는 자리에, 주변 지뢰의 갯수를 저장할 공간
	static boolean[][] visited; //까인지 안까인지 여부
	static int N; //맵의 크기
	static int ans; //클릭한 횟수
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 0;
			map = new char[N][N];
			cnt = new int[N][N];
			visited = new boolean[N][N];
			
			//0. 입력
			for(int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}
			//1. 지뢰가 없는 자리(후보)는, 8방에 지뢰의 갯수를 기록해둔다.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if( map[i][j] != '*' ) {
						int c = 0;
						for( int d = 0; d < 8; d++ ) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if( nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == '*' )
								c++;
						}
						cnt[i][j] = c;
					}
				}
			}
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(cnt[i]));
//			}
			//2. 0인 친구들에 대해서 dfs 고고
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != '*' && cnt[i][j] == 0 && !visited[i][j]) {
						ans++;
						dfs(i, j);
					}
				}
			}
			
			//3. 0이 아닌데 아직 안눌린애들 한번씩 눌러주자.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if( cnt[i][j] > 0 && !visited[i][j])
						ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	static void dfs(int r, int c) {
		//해당 위치를 방문한걸로 체크.
		visited[r][c] = true;
		
		//내가 0이라면.
		if(cnt[r][c] == 0) {			
			//	8방에 대해서 지뢰가 아니라면
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//	재귀호출
				if( nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != '*' && !visited[nr][nc])
					dfs(nr, nc);
			}
		}
	}
}