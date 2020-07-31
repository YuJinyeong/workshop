import java.util.Scanner;

public class card2_규칙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1. N과 가장 가까운 2의 제곱수를 찾는다.
		// 2. N - (그 제곱 수 ) * 2 가 답.

		int n = 1;
		while (n < N) {
			n *= 2;
		}
		// 여기서 n은 N보다 큰 2의 제곱수
		n /= 2; // 직전 제곱수

		if (N == 1) {
			System.out.println(1);
		} else {
			System.out.println((N - n) * 2);
		}
	}

}
