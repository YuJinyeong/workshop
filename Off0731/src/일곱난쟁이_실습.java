import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_실습 {

	static int N = 9;
	static int R = 2;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[N];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		sum -= 100;

		Arrays.sort(arr);
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] + arr[j] == sum) {
					printArr(i, j);
					return;
				}
			}
		}

	}

	private static void printArr(int i, int j) {
		int[] copy = new int[N - R];
		for (int idx = 0, idx_c = 0; idx < N; idx++) {
			if (idx == i || idx == j)
				continue;
			copy[idx_c] = arr[idx];
			idx_c++;
		}

		for (int idx = 0; idx <copy.length; idx++) {
			System.out.println(copy[idx]);
		}
	}

}
