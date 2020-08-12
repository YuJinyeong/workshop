import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


// 내 위에가 0이면서 내가 0이 아니면 행렬의 시작 행
// 내 왼쪽이 0이면서 내가 0이 아니면 행렬의 시작 열
// 각 맵에 자신의 행/렬의 값을 적어두자
// 그러면 나는 0이 아니면서 내 오른쪽도 0이고 아래도 0이면 행렬의 끝점이고
// 그 자리의 행.렬 값은 행렬의 크기가 됨.

public class 행렬찾기 {

	static class Rect implements Comparable<Rect> {
		int r, c, size;

		Rect(int r, int c) {
			this.r = r;
			this.c = c;
			this.size = r * c;
		}

		@Override
		public int compareTo(Rect o) {
			// TODO Auto-generated method stub
			if (this.size == o.size)
				return Integer.compare(this.r, o.r);
			return Integer.compare(this.size, o.size);
		}

		@Override
		public String toString() {
			return this.r + " " + this.c + " ";
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 내 위에가 0이면서 내가 0이 아니면 행렬의 시작 행
		// 내 왼쪽이 0이면서 내가 0이 아니면 행렬의 시작 열
		// 각 맵에 자신의 행/렬 의 값을 적어두자.
		// 그러면 나는 0이 아니면서 내 오른쪽도 0이고 아래도 0이면 행렬의 끝점이고
		// 그 자리의 행.렬 값은 행렬의 크기가 됨.
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 입력받아봐서
					int val = sc.nextInt();
					// 내가 0이 아니면서 위에가 0이면 난 행의 시작
					// 내가 0이 아니면서 왼쪽이 0이면 난 열의 시작
					if (val != 0) {
						// 내 위에가 0이면 행렬이 시작되있음. 그럼 내 열은 왼쪽보다 하나 더 큼
						if (map[i - 1][j] == 0)
							map[i][j] = map[i][j - 1] + 1;
						else
							map[i][j] = map[i - 1][j] + 100;
					}
				}
			}
			ArrayList<Rect> list = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 내가 0이 아니면서, 내 오른쪽이 0이고 내 아래가 0이면 행렬의 끝임
					if (map[i][j] != 0 && map[i + 1][j] == 0 && map[i][j + 1] == 0) {
						int r = map[i][j] / 100 + 1;
						int c = map[i][j] % 100;
//							System.out.println(r + " " + c);
						list.add(new Rect(r, c));
					}
				}
			}
			Collections.sort(list);
			System.out.print("#" + tc + " " + list.size() + " ");
			for (Rect r : list) {
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
