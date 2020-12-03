package hong;
import java.util.Scanner;

public class SWEA1949�������� {
	static int N;//���� ũ��
	static int K;//�ִ� �� �� �ִ� ������
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
			//��ü ���� �Է¹����鼭 �� ���� ���� ��ġ�� ���
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					m = Math.max(m, map[i][j]);
				}
			}
			max = 0;
			//�� ���� ���� �ش��ϴ� ����Ʈ�鿡������ dfs ����
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
		//������ġ �湮üũ.
		visited[r][c] = true;
//		���� ����Դ��� �� �ִ밪�̶�� ���.
		max = Math.max(max, cnt);
//		4���⿡ ���� ����ĭ�� ���ؼ�.
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
//			���� ������ ������ ���� �н�
			if( nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
//			�湮������ �ִ� ���̸� �н�
			if( visited[nr][nc] )
				continue;
//			������̺��� ����ĭ�� ���̰� �۴ٸ�
//			�ش���ġ�� ���
			if( map[nr][nc] < height )
				dfs(nr, nc, isUsed, cnt + 1, map[nr][nc]);
//			������̺��� ����ĭ�� ���̰� ������ ������ K��ū ������ �� �� �ִٸ�
//			�ش���ġ�� ���̸� ���纸�� -1�� ���
			else if( !isUsed && map[nr][nc] - K < height )
				dfs(nr, nc, true, cnt + 1, height - 1);
		}
		//���� ��ġ �ȿ°ɷ� ����
		visited[r][c] = false;
	}
}