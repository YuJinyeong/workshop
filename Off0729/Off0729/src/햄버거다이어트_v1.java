import java.util.Scanner;

public class �ܹ��Ŵ��̾�Ʈ_v1 {
	// ����Լ����� �����ؾߵ� �����ʹ� ��� static����
	// N, L, �׸��� ũ�� N�� Į�θ� �迭�� ������ �迭, �׸��� ������ ������ ����
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;
	static boolean[] sel;

	// idx��° ���Ҹ� ������ ������?
	static void powerSet(int idx) {
		int sum = 0;

		// �� �� ��
		if (idx == N) {
			int sumCal = 0;
			int sumScore = 0;
			// ���õ� ���鿡 ���ؼ� Į�θ�, ������ �� ���� ���غ���.
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sumCal += cals[i];
					sumScore += scores[i];
				}
			}
			// �� ���غ��� �� Į�θ� ���� L ���� �� sumScore�� �ִ밪�� �������.
			if(sumCal <= L && sumScore > ans)
				ans = sumScore;
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1);
		
		sel[idx] = false;
		powerSet(idx + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N�� L�� �Էµǰ�. N�ٿ� ���ļ� Į�θ�. �������� ���� �Էµ�(1 <= N <= 20, 1<= L <= 10000)
			N = sc.nextInt();
			L = sc.nextInt();
			cals = new int[N];
			scores = new int[N];
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			ans = 0;
			powerSet(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

}
