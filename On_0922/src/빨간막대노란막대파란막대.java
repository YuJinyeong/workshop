
public class 빨간막대노란막대파란막대 {

	public static void main(String[] args) {
		// f(50)을 구하고자 한다. 50번재를 저장할 수 있도록 51칸을 만들자.
		int[] dp = new int[31];
		//f(1) = 2, f(2) = 5
		dp[1] = 2;
		dp[2] = 5;
		for(int i = 3; i<=30; i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
		System.out.println(dp[30]);
	}

}
