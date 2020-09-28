import java.util.Scanner;

public class KnapsackTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];
		int[] D = new int[N + 1]; // 0~N 아이템까지 고려

		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		// 모든 아이템에 대해서 반복
		for (int i = 1; i <= N; i++) {
			//가방의 최대무게부터 자신의 무게까지 시도 : 가방에 넣을 수 있는 무게만 시도
			for(int w=W; w>=weights[i]; w--) {
				if(D[w] < profits[i] + D[w-weights[i]]) {
					D[w] = profits[i] + D[w-weights[i]];
				}
			}
			
		}
		System.out.println(D[W]); // 마지막 아이템까지 고려한 W무게를 만족하는 최대가치
	}
}
