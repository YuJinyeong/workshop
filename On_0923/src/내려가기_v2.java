import java.util.Scanner;

public class 내려가기_v2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] map = new int[3];
		// dp는 각 두줄만 가지고 돌려가며 쓴다.
		int[][] max = new int[2][3];
		int[][] min = new int[2][3];

		// 일단 첫줄을 입력받는다.
		// dp배열들의 첫행을 첫번째 입력값으로 채워둔다.
		for (int i = 0; i < 3; i++)
			max[0][i] = min[0][i] = map[i] = sc.nextInt();

		// 두번째 줄 부터 계산해나간다
		for (int i = 1; i < N; i++) {
			//현재 라인을 입력받아서.
			for (int j = 0; j < 3; j++)
				map[j] = sc.nextInt();
			//위에줄에서 해당되는 큰값을 찾아서 아랫줄에 쓴다.
			max[1][0] = Math.max(max[0][0], max[0][1]);
			max[1][2] = Math.max(max[0][2], max[0][1]);
			max[1][1] = Math.max(max[1][0], max[1][2]);
			
			min[1][0] = Math.min(min[0][0], min[0][1]);
			min[1][2] = Math.min(min[0][2], min[0][1]);
			min[1][1] = Math.min(min[1][0], min[1][2]);
			
			//내 위치의 값을 나에게 더해준다..
			//그리고. 1번행을 0번행으로 올린다.
			for(int j = 0; j < 3; j++) {
				max[1][j] += map[j];
				min[1][j] += map[j];
				max[0][j] = max[1][j];
				min[0][j] = min[1][j];
			}
		}
		int ans_max = 0;
		int ans_min = 987654321;
		for(int i = 0; i < 3; i++) {
			ans_max = Math.max(max[0][i], ans_max);
			ans_min = Math.min(min[0][i], ans_min);
		}
		System.out.println(ans_max + " " + ans_min);
	}
}
