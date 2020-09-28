import java.util.Scanner;

public class 거듭제곱 {
	// 입력으로 들어오는 N의 M제곱을 계산하여 출력하시오. 숫자가 클 경우 1234567891 로 나눈 나머지를 출력.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		System.out.println(power(N, M));
	}

	static final int MOD = 1234567891;

	// n의 m승을 구하는 함수.
	public static long power(int n, int m) {
		if (m == 1)
			return n;
		long tmp = power(n, m / 2);
		// 홀수 승일때는
		if (m % 2 == 1) {
			return tmp * tmp % MOD * n % MOD;
		} else
			return tmp * tmp % MOD;
	}

}
