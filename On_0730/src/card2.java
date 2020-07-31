import java.util.Scanner;

public class card2 {
	static int[] arr;
	static int N = 0;
	

	public static void del() {
		for (int i = 0; i < N - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[N - 1] = 0;
		N--;
	}

	public static void back() {
		int temp = arr[0];
		del();
		N += 1;
		arr[N - 1] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		while (N > 1) {
			del();
			back();
		}
		System.out.println(arr[0]);

	}

}
