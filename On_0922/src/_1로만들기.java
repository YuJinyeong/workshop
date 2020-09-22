import java.util.Scanner;

public class _1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 0;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;//일단 1뺴는 경우의 값을 넣어두자..
			if( i % 2 == 0 ) {
				//2로 나눴을때의 최적값에 1더한 값과 현재 값 중 작은 걸로..
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			if( i % 3 == 0 ) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}

}
