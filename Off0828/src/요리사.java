import java.util.Arrays;
import java.util.Scanner;

//하루에 한번씩 부분집합 조합 순열 코드를 N이 3정도로 디버깅 혹은 코드작성을 매일매일
public class 요리사 {
	static boolean[] sel;
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			sel = new boolean[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			ans = 987654321;
			powerSet(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int ans;
	static void powerSet(int idx, int s_idx) {
		if( s_idx == N / 2) {
			//각 true / false별로. 요리 맛을 구하자
			int sumT = 0, sumF = 0;
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					for(int j = 0; j < N; j++) {
						if(sel[j]) 
							sumT += map[i][j];
					}
				}
				else {
					for(int j = 0; j < N; j++) {
						if(!sel[j]) 
							sumF += map[i][j];
					}
				}
			}
//			System.out.println(Math.abs(sumT - sumF));
			ans = Math.min(ans, Math.abs(sumT - sumF));
			
			return;
		}
		if( idx == N ) {
			return;
		}
		sel[idx] = true;
		powerSet(idx + 1, s_idx + 1);
		sel[idx] = false;
		powerSet(idx + 1, s_idx);
	}
}
