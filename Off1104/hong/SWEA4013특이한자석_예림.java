package hong;

import java.util.Scanner;

public class SWEA4013특이한자석_예림 {
	static int[][] arr = new int[4][8];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 8; j++)
				arr[i][j] = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int num = sc.nextInt();
			int dir = sc.nextInt();
			fun(num, dir);
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}

		System.out.println(result);
	}

	static void fun(int num, int dir) {
		int[] d = new int[4];
		d[--num] = dir;
		if (num == 0) {
			if (arr[0][2] != arr[1][6])
				d[1] = d[0] * -1;
			if (arr[1][2] != arr[2][6])
				d[2] = d[1] * -1;
			if (arr[2][2] != arr[3][6])
				d[3] = d[2] * -1;
		} else if (num == 1) {
			if (arr[0][2] != arr[1][6])
				d[0] = d[1] * -1;
			if (arr[1][2] != arr[2][6])
				d[2] = d[1] * -1;
			if (arr[2][2] != arr[3][6])
				d[3] = d[2] * -1;
		} else if (num == 2) {
			if (arr[1][2] != arr[2][6])
				d[1] = d[2] * -1;
			if (arr[2][2] != arr[3][6])
				d[3] = d[2] * -1;
			if (arr[0][2] != arr[1][6])
				d[0] = d[1] * -1;
		} else {
			if (arr[2][2] != arr[3][6])
				d[2] = d[3] * -1;
			if (arr[1][2] != arr[2][6])
				d[1] = d[2] * -1;
			if (arr[0][2] != arr[1][6])
				d[0] = d[1] * -1;
		}

		for (int i = 0; i < 4; i++) {
			if (d[i] == 1)
				rotateR(i);
			else if (d[i] == -1)
				rotateL(i);
		}
	}

	static void rotateL(int num) {
		int temp = arr[num][0];
		for (int i = 0; i < 7; i++)
			arr[num][i] = arr[num][i + 1];
		arr[num][7] = temp;
	}

	static void rotateR(int num) {
		int temp = arr[num][7];
		for (int i = 7; i >= 1; i--)
			arr[num][i] = arr[num][i - 1];
		arr[num][0] = temp;
	}
}