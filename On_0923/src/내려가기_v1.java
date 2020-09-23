import java.util.Scanner;

public class 내려가기_v1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		
		//input
		for(int i = 0; i < N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		//첫번쨰줄은 그대로.
		for(int i = 0; i < 3; i++) {
			max[0][i] = map[0][i];
			min[0][i] = map[0][i];
		}
		//두번째줄부터는 윗 행의 해당되는 칸중 가장 큰값에 나를 더한다.
		for(int i = 1; i < N; i++) {
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]);
			max[i][2] = Math.max(max[i-1][2], max[i-1][1]);
			max[i][1] = Math.max(max[i][0], max[i][2]);
			
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]);
			min[i][2] = Math.min(min[i-1][2], min[i-1][1]);
			min[i][1] = Math.min(min[i][0], min[i][2]);
			
			for(int j = 0; j < 3; j++) {
				max[i][j] += map[i][j];
				min[i][j] += map[i][j];
			}
		}
		int ans_max = 0;
		int ans_min = 987654321;
		for(int i = 0; i < 3; i++) {
			ans_max = Math.max(max[N-1][i], ans_max);
			ans_min = Math.min(min[N-1][i], ans_min);
		}
		System.out.println(ans_max + " " + ans_min);
	}
}
