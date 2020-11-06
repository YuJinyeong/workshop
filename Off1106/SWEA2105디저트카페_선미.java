import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105디저트카페_선미 {
	static int N, ans, map[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			// 기준점(맨위)
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					// 가로
					for (int n = j; n > 0; n--) {
						// 세로
						for (int m = N - j - 1; m > 0; m--)
							ans = Math.max(ans, setRange(i, j, n, m));
					}
				}
			}
			ans = (ans == 0 ? -1 : ans);
			System.out.println("#" + tc + " " + ans);
		}
		System.exit(0);
	}

	static int setRange(int x, int y, int n, int m) {
		if ((n + 1) * 2 + (m + 1 - 2) * 2 <= ans)
			return 0;
		if (y - n < 0 || y + m >= N || x + n + m >= N)
			return 0;
		visited = new boolean[101];
		int cnt = 0;

		for (int i = x, j = y; i < x + m; i++, j++) {
			if (visited[map[i][j]])
				return 0;
			visited[map[i][j]] = true;
			cnt++;
		}
		for (int i = x + m, j = y + m; i < x + m + n; i++, j--) {
			if (visited[map[i][j]])
				return 0;
			visited[map[i][j]] = true;
			cnt++;
		}
		for (int i = x + m + n, j = y + m - n; i > x + n; i--, j--) {
			if (visited[map[i][j]])
				return 0;
			visited[map[i][j]] = true;
			cnt++;
		}
		for (int i = x + n, j = y - n; i > x; i--, j++) {
			if (visited[map[i][j]])
				return 0;
			visited[map[i][j]] = true;
			cnt++;
		}
		return cnt;
	}
}