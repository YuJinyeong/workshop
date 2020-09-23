import java.util.Scanner;

public class Knapsack {
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
			int[][] dp = new int[N+1][K+1]; //0번행은 아이템안고르는 경우. i번 행은 i번째 아이템도 추가로 고려하는 경우.
			for(int i = 1; i < N+1; i++) {
				//dp테이블을 1번행부터 N번행까지 채워나간다.
				//1번행은 첫번째 아이템 한개만 고려해서 배낭을 채우는 가치.
				//2번행은 첫번쨰 아이템 + 두번째아이템을 고려해서 배낭을 채우는 가치.
				//N번행은 첫번째.... N번째 아이템을 고려해서 배낭을 채우는 가치.
				
				
				//모든 배낭 무게에 대해서 채워나가자..
				for(int j = 0; j < K+1; j++) {
					//n번째 아이템을 채울때. 배낭의 무게가 아이템을 담을 수 없는 경우. 위에칸을 그대로 가져옴.
					if( j < items[i][0] )
						dp[i][j] = dp[i-1][j];
					//n번째 아이템을 담을 수 있는 경우. 위에칸에서 아이템의 부피만큼 왼쪽 칸의 값에 아이템의 가치를 더한 값과. 위에값 중 큰 값을 선택
					else {
						dp[i][j] = Math.max(dp[i-1][j - items[i][0]]+items[i][1], dp[i-1][j]);
					}
				}
			}
			System.out.println("#" + tc + " " + dp[N][K]);
		}
	}
}