import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class N과M_1 {
	private static int N, M;
	private static int[] numbers, input;
	private static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		isSelected = new boolean[N];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		permutation(0);
	}

	private static void permutation(int cnt) {

		StringBuilder sb = new StringBuilder();

		if (cnt == M) {
			for (int j = 0; j < M; j++) {
				sb.append(numbers[j] + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;

			permutation(cnt + 1);

			isSelected[i] = false;
		}
	}

}
