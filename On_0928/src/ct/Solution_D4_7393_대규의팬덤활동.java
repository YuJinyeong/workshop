package ct;
import java.util.Scanner;

//BJ 1562 
public class Solution_D4_7393_대규의팬덤활동 {

	static int T;
	static int N;
	static int VISIT=(1<<10);
	static int MOD=1000000000;
	static long dp[][][];
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt(); // 자릿수
			dp=new long[101][10][VISIT];
			//[i][j][k]  [자릿수][숫자][자릿수-1 위치에서 앞단계 마킹]
			System.out.println("#"+t+" "+godp());
		}
	}

	private static long godp() {
		long sum=0L;
		for (int j = 1; j<10; j++) {
			dp[1][j][1<<j]=1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < VISIT; k++) {
					int bit= k | (1<<j);
					dp[i][j][bit]=
							(dp[i][j][bit]%MOD+
							((0<j ? dp[i-1][j-1][k] :0 )%MOD+
							(9>j ? dp[i-1][j+1][k] :0 )%MOD)%MOD)%MOD;
				}
			}
		}
		for (int j = 0; j < 10; j++) {
			sum=(sum+dp[N][j][VISIT-1])%MOD;
		}
		
		return sum;
	}

}
