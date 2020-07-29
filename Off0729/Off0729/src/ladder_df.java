import java.util.Scanner;

public class ladder_df {
	
	static final int SIZE = 100;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			int[][] map = new int[SIZE][SIZE];

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++)
					map[i][j] = sc.nextInt();
			}

			int goalIdx = 0;
			int[] lanes = new int[SIZE];
			int idx = 0;
			for (int j = 0; j < SIZE; j++) {
				if (map[SIZE - 1][j] != 0) {
					if (map[SIZE - 1][j] == 2)
						goalIdx = idx;
					lanes[idx++] = j;
				}

			}

			// 올라갈거야
			int curIdx = goalIdx;
			for (int i = SIZE - 1; i >= 0; i--) {

				// 왼쪽 낭떠러지가 아니다
				if (lanes[curIdx] - 1 >= 0 && map[i][lanes[curIdx] - 1] == 1)
					curIdx--;
				else if (lanes[curIdx] + 1 < SIZE && map[i][lanes[curIdx] + 1] == 1)
					curIdx++;
			}
			System.out.println("#" + tc + " " + lanes[curIdx]);

		}

	}
}
