import java.util.Arrays;
import java.util.Scanner;

public class N과M_3 {

	private static int N = 3, R = 3;
	private static int[] num;

	public static void main(String[] args) {
		num = new int[R];
		permutation(0);
	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(num));
			return;
		}

		for (int i = 1; i <= N; i++) {
			num[cnt] = i;
			permutation(cnt + 1);
		}
	}

}
