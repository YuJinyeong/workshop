import java.util.Scanner;

public class flatten {
	static int min_idx = 1;
	static int max_idx = 100;

	public static int findMin(int[] height) {
		int idx = min_idx;
		while (true) {
			if (height[idx] != 0) {
				min_idx = idx;
				return idx;
			}
			idx++;
		}
	}

	public static int findMax(int[] height) {
		int idx = max_idx;
		while (true) {
			if (height[idx] != 0) {
				max_idx = idx;
				return idx;
			}
			idx--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			min_idx = 1;
			max_idx = 100;
			int dump = sc.nextInt();
			int height[] = new int[101];

			for (int i = 0; i < 100; i++) {
				int input = sc.nextInt();
				height[input]++;
			}

			for (int i = 0; i < dump; i++) {
				int min = findMin(height);
				int max = findMax(height);

				height[min + 1] += 1;
				height[min] -= 1;
				height[max] -= 1;
				height[max - 1] += 1;

			}

			int min = findMin(height);
			int max = findMax(height);

			System.out.println("#" + test_case + " " + (max - min));
		}
	}

}
