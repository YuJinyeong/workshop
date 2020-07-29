import java.util.Scanner;

public class hamburger {

	static int Answer = 0;
	static int L, N;
	static boolean[] sel;

	public static void cook(int[][] prep, int idx) {
		int score = 0;
		int cal = 0;

		if (idx == N) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					score += prep[i][0];
					cal += prep[i][1];
					if (cal > L) {
						return;
					}
				}
			}
			if (score > Answer)
				Answer = score;
			return;
		}

		sel[idx] = true;
		cook(prep, (idx + 1));

		sel[idx] = false;
		cook(prep, (idx + 1));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			sel = new boolean[N];
			int[][] prep = new int[N][2];

			for (int i = 0; i < N; i++) {
				prep[i][0] = sc.nextInt();
				prep[i][1] = sc.nextInt();
			}

			cook(prep, 0);
			System.out.println("#" + tc + " " + Answer);
			Answer = 0;
		}
	}

}
