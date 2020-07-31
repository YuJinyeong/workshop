import java.util.Scanner;

public class 햄버거다이어트_v1 {
	// 재귀함수에서 접근해야될 데이터는 모두 static으로
	// N, L, 그리고 크기 N의 칼로리 배열과 맛점수 배열, 그리고 정답을 저장할 변수
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;
	static boolean[] sel;

	// idx번째 원소를 고를건지 말건지?
	static void powerSet(int idx) {
		int sum = 0;

		// 다 고른 것
		if (idx == N) {
			int sumCal = 0;
			int sumScore = 0;
			// 선택된 재료들에 대해서 칼로리, 점수의 각 합을 구해보자.
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sumCal += cals[i];
					sumScore += scores[i];
				}
			}
			// 다 더해봤을 때 칼로리 합이 L 이하 중 sumScore의 최대값을 기억하자.
			if(sumCal <= L && sumScore > ans)
				ans = sumScore;
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1);
		
		sel[idx] = false;
		powerSet(idx + 1);
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
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			ans = 0;
			powerSet(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

}
