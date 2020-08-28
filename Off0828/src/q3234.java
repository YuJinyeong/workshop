import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D4 - Q.3234 준환이의 양팔저울
public class q3234 {
	static int[] arr, sel;
	static int N, cnt;
	static boolean[] check;

	static void powerSet(int idx, int sumL, int sumR) {
		if (sumR >= sumL)
			return;
		if (idx == N) {
			cnt++;
			return;
		}

		powerSet(idx + 1, sumL + sel[idx], sumR);
		powerSet(idx + 1, sumL, sumR + sel[idx]);
	}

	static void perm(int idx) {
		// 모두 골랐다.
		if (idx == N) {
			powerSet(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			// 안고른 놈에 대해서만
			if (!check[i]) {
				check[i] = true;// 고른걸로 체크해두고
				sel[idx] = arr[i];
				perm(idx + 1);
				check[i] = false;// 다시 돌아왔을땐 체크해제
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			sel = new int[N];
			check = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			perm(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
