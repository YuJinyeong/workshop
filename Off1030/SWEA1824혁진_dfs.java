import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1824혁진_dfs {
	static int t, r, c;
	static boolean visit[][][][], flag, can;
	static String map[];
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new String[r];
			visit = new boolean[r][c][4][16];
			flag = false;
			for (int i = 0; i < r; i++) {
				map[i] = br.readLine();

			}
			dfs(0, 0, 1, 0);// 무한 반복 조건은 현재위치를 값은값과 같은 방향을 가지고 방문한 기록이 있으면
			if (flag) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}
		}
	}

	private static void dfs(int x, int y, int d, int sum) {
		if (visit[x][y][d][sum])
			return;
		visit[x][y][d][sum] = true;
		if (map[x].charAt(y) == '?') {
			visit[x][y][0][sum] = true;
			visit[x][y][1][sum] = true;
			visit[x][y][2][sum] = true;
			visit[x][y][3][sum] = true;
			for (int di = 0; di < 4; di++) {
				d = di;
				int x1 = (x + dir[d][0] + r) % r;
				int y1 = (y + dir[d][1] + c) % c;

				dfs(x1, y1, d, sum);
				if (flag) {
					return;
				}
			}
		} else {
			if (map[x].charAt(y) == '<') {
				d = 3;
			} else if (map[x].charAt(y) == '>') {
				d = 1;
			} else if (map[x].charAt(y) == '^') {
				d = 0;
			} else if (map[x].charAt(y) == 'v') {
				d = 2;
			} else if (map[x].charAt(y) == '_') {
				if (sum == 0) {
					d = 1;
				} else {
					d = 3;
				}
			} else if (map[x].charAt(y) == '|') {
				if (sum == 0) {
					d = 2;
				} else {
					d = 0;
				}
			} else if (map[x].charAt(y) == '.') {

			} else if (map[x].charAt(y) == '@') {
				flag = true;
				return;
			} else if (map[x].charAt(y) >= '0' && map[x].charAt(y) <= '9') {
				sum = map[x].charAt(y) - '0';
			} else if (map[x].charAt(y) == '+') {
				sum++;
				if (sum > 15) {
					sum = 0;
				}
			} else if (map[x].charAt(y) == '-') {
				sum--;
				if (sum < 0) {
					sum = 15;
				}
			}
			int x1 = (x + dir[d][0] + r) % r;
			int y1 = (y + dir[d][1] + c) % c;
			dfs(x1, y1, d, sum);

		}
	}
}
