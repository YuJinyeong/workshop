
public class �κ������������ִ� {

	static int[] arr;
	static boolean[] sel;
	static int N;
	static int ans = 0;

	static void powerSet(int idx) {
		if (idx == N) {
			int sum = 0;
			// sel�� true�� �ε����� arr�� ���ҵ��� ��� ���ϸ� �κ������� ��
			for (int i = 0; i < N; i++) {
				if (sel[i])
					sum += arr[i];
			}
			if (ans < sum)
				ans = sum;
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1);

		sel[idx] = false;
		powerSet(idx + 1);
	}

	public static void main(String[] args) {
		N = 3;
		arr = new int[N];
		sel = new boolean[N];

		arr[0] = 10;
		arr[1] = -17;
		arr[2] = 54;

		ans = 0;
		powerSet(0);
		System.out.println(ans);

	}

}
