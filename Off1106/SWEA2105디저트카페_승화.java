import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105디저트카페_승화 {

	static int map[][], t, n, dir[][] = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } }, count = -1;
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			count = -1;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					ll: for (int le = 1; le < n; le++) {
						for (int re = 1; re < n; re++) {
							int rx = i + dir[0][0] * le;
							int ry = j + dir[0][1] * le;
							if (rx >= n || ry >= n) {
								break ll;
							}
							int lx = rx + dir[1][0] * re;
							int ly = ry + dir[1][1] * re;
							if (lx >= n || ly < 0) {
								break;
							}
							int lastx = lx + dir[2][0] * le;
							int lasty = ly + dir[2][1] * le;
							if (lastx < 0 || lasty < 0)
								break;
							find(i, j, le, re);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	private static void find(int x, int y, int le, int re) {
		visit = new boolean[101];
		visit[map[x][y]] = true;
		for (int i = 0; i < le; i++) {
			x += dir[0][0];
			y += dir[0][1];
			if (visit[map[x][y]])
				return;
			visit[map[x][y]] = true;
		}
		for (int i = 0; i < re; i++) {
			x += dir[1][0];
			y += dir[1][1];
			if (visit[map[x][y]])
				return;
			visit[map[x][y]] = true;
		}
		for (int i = 0; i < le; i++) {
			x += dir[2][0];
			y += dir[2][1];
			if (visit[map[x][y]])
				return;
			visit[map[x][y]] = true;
		}
		for (int i = 0; i < re - 1; i++) {
			x += dir[3][0];
			y += dir[3][1];
			if (visit[map[x][y]])
				return;
			visit[map[x][y]] = true;
		}
		count = Math.max(re * 2 + le * 2, count);
	}
}