package hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4013특이한자석_선미 {
	static int info[][], top[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			top = new int[4];
			info = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					info[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int val = Integer.parseInt(st.nextToken()) * -1;
				rotate(idx, val);
			}
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				if (info[i][top[i]] == 1)
					ans += Math.pow(2, i);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void rotate(int idx, int val) {
		boolean[] isSame = new boolean[3];
		for (int i = 0; i < 3; i++) {
			if (info[i][(top[i] + 2) % 8] == info[i + 1][(top[i + 1] + 6) % 8])
				isSame[i] = true;
		}
		top[idx] = (top[idx] + val + 8) % 8;
		int tmp = val * -1;
		for (int i = idx + 1; i < 4; i++) {
			if (isSame[i - 1])
				break;
			top[i] = (top[i] + tmp + 8) % 8;
			tmp *= -1;
		}
		tmp = val * -1;
		for (int i = idx - 1; i >= 0; i--) {
			if (isSame[i])
				break;
			top[i] = (top[i] + tmp + 8) % 8;
			tmp *= -1;
		}
	}
}
