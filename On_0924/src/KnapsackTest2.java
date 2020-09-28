import java.util.Scanner;

public class KnapsackTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];
		int[][] D = new int[N + 1][W + 1]; // 0~N 아이템까지 고려, 0~W 무게까지 고려

		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		// 모든 아이템에 대해서 반복
		for (int i = 1; i <= N; i++) {
			// 현 아이템의 1부터 목표무게 까지의 가치테이블을 만든다.
			for (int w = 1; w <= W; w++) {
				// 현 아이템의 무게가 가치테이블을 만들기 위해 무게보다 작거나 같다면
				// 선택 가능하며, 아래 둘 중 최대 가치를 선택한다.
				// 1)현 아이템을 선택하지 않았을 경우의 가치는 가치테이블에서 같은 무게의 이전아이템까지의 가치
				// 2)현 아이템을 선택했을 때의 가치와 가치테이블에서 해당 아이템의 무게만큼 뺀 무게의 이전아이템까지의 가치
				if (weights[i] <= w) {
					D[i][w] = Math.max(D[i - 1][w], profits[i] + D[i - 1][w - weights[i]]);
				} else { // 현 아이템의 무게가 가치테이블을 만들기 위한 무게보다 크다면 현 아이템 선택불가하므로
							// 최적의 가치는 가치테이블에서 같은 무게의 이전아이템까지의 가치
					D[i][w] = D[i - 1][w];
				}
			}
		}
		System.out.println(D[N][W]); // 마지막 아이템까지 고려한 W무게를 만족하는 최대가치
	}
}
