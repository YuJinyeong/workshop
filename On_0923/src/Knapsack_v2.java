import java.util.Scanner;

public class Knapsack_v2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 아이템의 갯수. 1≤N≤100
			int K = sc.nextInt(); // 배낭의 최대 부피. 1≤K≤1000
			int[][] items = new int[N+1][2]; //각 행의 0번칸은 부피. 1번칸은 가치. 행번호는 아이템 번호. 

			for(int i = 1; i < N+1; i++) {
				items[i][0] = sc.nextInt();
				items[i][1] = sc.nextInt();
			}
			
			int[][] dp = new int[2][K+1];
			for(int i = 1; i < N+1; i++) {
				for(int j = 0; j < K+1; j++) {
					if( j < items[i][0] )
						dp[1][j] = dp[0][j];
					else {
						dp[1][j] = Math.max(dp[0][j - items[i][0]]+items[i][1], dp[0][j]);
					}
				}
				for(int j = 0; j < K+1; j++) {
					dp[0][j] = dp[1][j];
				}
			}
			System.out.println("#" + tc + " " + dp[0][K]);
		}
	}
}