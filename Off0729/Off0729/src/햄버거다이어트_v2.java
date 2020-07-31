import java.util.Scanner;

public class 햄버거다이어트_v2 {
	// 재귀함수에서 접근해야될 데이터는 모두 static으로
	// N, L, 그리고 크기 N의 칼로리 배열과 맛점수 배열, 그리고 정답을 저장할 변수
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;

	// idx번째 재료에 대해서 먹을지 안먹을지를 결정하는 함수
	// 먹겠다면 지금까지의 칼로리합 점수합에다가 해당 재료의 칼로리, 맛을 더하고
	// 안먹겠다면 지금까지의 칼로리합 점수합을 그대로 가지고 다음 재료로 가면 됨
	static void burger(int idx, int sumCal, int sumScore) {
		
		System.out.println("burger(" + idx + ", " + sumCal + ", " + sumScore + ")");
		
		if (sumCal > L)
			return;

		if (idx == N) {
			if (sumCal <= L && ans < sumScore)
				ans = sumScore;
			return;
		}
		
		burger(idx + 1, sumCal + cals[idx], sumScore + scores[idx]);
		burger(idx + 1, sumCal, sumScore);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N과 L이 입력되고. N줄에 걸쳐서 칼로리. 맛점수가 각각 입력됨(1 <= N <= 20, 1<= L <= 10000)
			N = sc.nextInt();
			L = sc.nextInt();
			cals = new int[N];
			scores = new int[N];

			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			ans = 0;
			burger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}

	}

}
