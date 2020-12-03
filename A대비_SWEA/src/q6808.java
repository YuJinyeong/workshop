import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//6808. 규영이와 인영이의 카드게임
public class q6808 {
	static int gue[], ans;
	static boolean check[];
	static final int TOTAL = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			gue = new int[9];
			check = new boolean[19];
			ans = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int i = 0; i < 9; i++) {
				gue[i] = Integer.parseInt(st.nextToken());
				check[gue[i]] = true;
			}

			Arrays.sort(gue);
			permInn(0, 0, 0);

			System.out.println("#" + tc + " " + ans + " " + (TOTAL - ans));
		}
	}

	private static void permInn(int idx, int scr_gue, int scr_inn) {

		if (idx == 9) {
			if (scr_gue > scr_inn)
				ans++;
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (!check[i]) {
				check[i] = true;

				if (gue[idx] > i)
					permInn(idx + 1, scr_gue + gue[idx] + i, scr_inn);
				else
					permInn(idx + 1, scr_gue, scr_inn + gue[idx] + i);

				check[i] = false;
			}
		}
	}
}
