import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D4 - Q.4012 요리사
public class q4012 {

	static int N, ans, sub;
	static int[][] synergy;
	static int[] choice1, choice2;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			choice1 = new int[N / 2];
			choice2 = new int[N / 2];
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 987654321;
			cooking(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void cooking(int idx, int s_idx) {
		if (s_idx == (N / 2)) {
			for (int i = 0, j = 0; i < N; i++) {
				if (!check[i]) {
					choice2[j] = i;
					j++;
				}
			}
			sub = calc();
//			System.out.println("sub: " + sub);
			ans = Math.min(ans, sub);
			return;
		}
		
		if(idx == N) 
			return;
		
		choice1[s_idx] = idx;
		check[idx] = true;
		cooking(idx+1, s_idx+1);
		check[idx] = false;
		cooking(idx+1, s_idx);
	}

	private static int calc() {
		int sum1 = 0, sum2 = 0;

		// choice 시너지 합 구하기
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N/2; j++) {
				sum1 += synergy[choice1[i]][choice1[j]];
			}
		}

		// 나머지 재료의 시너지 합 구하기
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N/2; j++) {
				sum2 += synergy[choice2[i]][choice2[j]];
			}
		}

		return Math.abs(sum1 - sum2);
	}

}
