import java.util.Scanner;

public class �ܹ��Ŵ��̾�Ʈ_v2 {
	// ����Լ����� �����ؾߵ� �����ʹ� ��� static����
	// N, L, �׸��� ũ�� N�� Į�θ� �迭�� ������ �迭, �׸��� ������ ������ ����
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;

	// idx��° ��ῡ ���ؼ� ������ �ȸ������� �����ϴ� �Լ�
	// �԰ڴٸ� ���ݱ����� Į�θ��� �����տ��ٰ� �ش� ����� Į�θ�, ���� ���ϰ�
	// �ȸ԰ڴٸ� ���ݱ����� Į�θ��� �������� �״�� ������ ���� ���� ���� ��
	static void burger(int idx, int sumCal, int sumScore) {
		
		System.out.println("burger(" + idx + ", " + sumCal + ", " + sumScore + ")");
		
		if (sumCal > L)
			return;

		if (idx == N) {
			if (sumCal <= L && ans < sumScore)
				ans = sumScore;
			return;
		}
		
		burger(idx + 1, sumCal + cals[idx], sumScore + scores[idx]);
		burger(idx + 1, sumCal, sumScore);
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

			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			ans = 0;
			burger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}

	}

}
