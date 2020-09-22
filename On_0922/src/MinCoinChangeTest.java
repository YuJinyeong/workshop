import java.util.Scanner;

public class MinCoinChangeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1]; // 각 금액의 최적 교환동전개수를 저장하는 동적테이블
		
		// 각 금액의 최적 교환 동전개수를 구함
		// 1원 시도했을 경우 최적개수: D[i-1]+1
		// 4원 시도했을 경우 최적개수: D[i-4]+1
		// 6원 시도했을 경우 최적개수: D[i-6]+1
		//
		// 위 세 경우의 가장 최적값을 저장
		int min;
		for(int i=1; i<=money; i++) {
			min = Integer.MAX_VALUE;
			if(i>=1 && D[i-1]+1<min) min = D[i-1] + 1;
			if(i>=4 && D[i-4]+1<min) min = D[i-4] + 1;
			if(i>=6 && D[i-6]+1<min) min = D[i-6] + 1;
			
			D[i] = min;
		}
		System.out.println(D[money]);
	}

}
