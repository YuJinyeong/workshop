import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1828��������_bfs {
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
						bfs(i, j);
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
	static void bfs(int r, int c) {
		//�ش� ��ġ�� �湮�Ѱɷ� üũ.
		visited[r][c] = true;
		//r,c��ġ�� ť�� �ְ�
		Queue<Integer> rQ = new LinkedList<>();
		Queue<Integer> cQ = new LinkedList<>();
		rQ.add(r);
		cQ.add(c);
		
		while(!rQ.isEmpty()) {
			int nowR = rQ.poll();
			int nowC = cQ.poll();
			//8�濡 ���ؼ�
			for(int d = 0; d < 8; d++) {
				int nr = nowR + dr[d];
				int nc = nowC + dc[d];
				if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] != '*') {
					visited[nr][nc] = true;
					if(cnt[nr][nc] == 0) {
						rQ.add(nr);
						cQ.add(nc);
					}
				}
			}
			//���ڰ� �ƴ϶��, �湮üũ�ϰ�
			//���߿����� 0�̶�� ť�� �ٽ� ����.
		}
	}
}