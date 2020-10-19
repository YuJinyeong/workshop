
public class 최소공최대공 {
	public static void main(String[] args) {
		System.out.println(solution(10, 50));
	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		// 두수의 크기 정렬
		int big, small;
		if (n > m) {
			big = n;
			small = m;
		} else {
			big = m;
			small = n;
		}
		answer[0] = gcd(big, small);
		answer[1] = big * small / answer[0];

		return answer;
	}

	public static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}
