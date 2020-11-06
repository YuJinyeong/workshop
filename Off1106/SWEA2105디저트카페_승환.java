
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105디저트카페_승환 {
	static int map[][], N;
	static int dr[] = { 1, 1, -1, -1 };
	static int dc[] = { 1, -1, -1, 1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = -1;
			for (int i = N - 1; i >= 2; i--) {
				for (int j = N - i + 1; j >= 2; j--) {
					int value = i * 2 + j * 2 - 4;
					if (value < result)
						continue;
					if (find(i, j)) {
						result = Math.max(result, value);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, result);
		}
	}

	static boolean find(int rowc, int colc) {
		for (int i = 0; i < N - 2; i++) { 
			for (int j = 1; j < N - 1; j++) {
				int rcnt = 1;
				int ccnt = 0;
				boolean isr = true;
				int d = 0; // 방향
				Point p = new Point(i, j);
				boolean[] dessert = new boolean[101];
				dessert[map[p.x][p.y]] = true;
				while (true) {
					if (isr)
						rcnt++;
					else
						ccnt++;
					p.x += dr[d];
					p.y += dc[d];
					if (p.x < 0 || p.y < 0 || p.x >= N || p.y >= N)
						break;
					if (p.x == i && p.y == j)
						return true;
					if (dessert[map[p.x][p.y]])
						break;

					dessert[map[p.x][p.y]] = true;

					if (rcnt == rowc || ccnt == colc) {
						isr = !isr;
						rcnt = 1;
						ccnt = 1;
						d++;
					}
				}
			}
		}
		return false;

	}

}
