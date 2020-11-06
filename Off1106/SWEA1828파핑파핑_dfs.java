import java.util.Arrays;
import java.util.Scanner;

public class SWEA1828��������_dfs {
	static char[][] map; //�ԷµǴ� ��
	static int[][] cnt; //���ڰ� ���� �ڸ���, �ֺ� ������ ������ ������ ����
	static boolean[][] visited; //������ �ȱ����� ����
	static int N; //���� ũ��
	static int ans; //Ŭ���� Ƚ��
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
			
			//0. �Է�
			for(int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}
			//1. ���ڰ� ���� �ڸ�(�ĺ�)��, 8�濡 ������ ������ ����صд�.
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
			//2. 0�� ģ���鿡 ���ؼ� dfs ���
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != '*' && cnt[i][j] == 0 && !visited[i][j]) {
						ans++;
						dfs(i, j);
					}
				}
			}
			
			//3. 0�� �ƴѵ� ���� �ȴ����ֵ� �ѹ��� ��������.
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
		//�ش� ��ġ�� �湮�Ѱɷ� üũ.
		visited[r][c] = true;
		
		//���� 0�̶��.
		if(cnt[r][c] == 0) {			
			//	8�濡 ���ؼ� ���ڰ� �ƴ϶��
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//	���ȣ��
				if( nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != '*' && !visited[nr][nc])
					dfs(nr, nc);
			}
		}
	}
}