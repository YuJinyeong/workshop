import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 Q.7576 토마토
public class 토마토_BFS {
	static int N, M; // N세로 M가로
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					queue.add(new Node(i, j));
			}
		}

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			int day = map[n.r][n.c];
			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				// 나가면 넘어감
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				// 토마토가 없음
				if (map[nr][nc] == -1)
					continue;

				// 이미 익은 토마토
				if (map[nr][nc] != 0)
					continue;

				map[nr][nc] = day + 1;
				queue.add(new Node(nr, nc));
			}
		}

		// 전체 토마토판을 검사하면서, 0이 남아있으면 실패
		// 0이 남아있지 않으면, 최대값을 찾아서 출력
		int max = 0;
		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, map[i][j]);
				if (map[i][j] == 0) {
					max = -1;
					break out;
				}
			}
		}
		System.out.println(max == -1 ? -1 : max - 1);
	}
}
