import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2105디저트카페_우진 {
	static class Node {
		int r, c; // 좌표
		int dir; // 내려가는 방향(0 : 왼쪽아래, 1: 오른쪽 아래)
		int move; // 이동횟수
		int change; // 방향회전 횟수

		Node(int r, int c, int dir, int move, int change) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.move = move;
			this.change = change;
		}
	}

	static int[][] array;
	static int[] dr = { 1, 1 };
	static int[] dc = { -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			int N = Integer.parseInt(in.readLine());
			array = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = -1;
			out: for (int k = N - 1; k > 1; --k) { // 마름모 전체 길이 지정
				for (int l = 1; l < k; ++l) {
					int d1 = l;
					int d2 = k - l;
					for (int i = 0; i < N - 2; ++i) {
						for (int j = 1; j < N - 1; ++j) {
//                            System.out.println(i + " " + j + " " + d1 + " " + d2);
							if (i + d1 + d2 < N && j + d2 < N && j - d1 >= 0) {
								if (makeSquare(i, j, d1, d2)) {
									ans = 2 * k;
									break out;
								}
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static boolean makeSquare(int i, int j, int d1, int d2) {
		boolean[] met = new boolean[101];
		Queue<Node> queue = new LinkedList<>();
		met[array[i][j]] = true;
		// 좌표 ,방향,이동횟수, 방향전환횟수
		queue.offer(new Node(i + dr[0], j + dc[0], 0, 1, 0));
		queue.offer(new Node(i + dr[1], j + dc[1], 1, 1, 0));

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (met[array[n.r][n.c]])
				return false;

			met[array[n.r][n.c]] = true;

			if (n.dir == 0 && n.move == d1) {
				if (n.change == 1) {
					return true;
				}
				queue.offer(new Node(n.r + dr[1], n.c + dc[1], 1, 1, 1));
				continue;

			} else if (n.dir == 1 && n.move == d2) {
				if (n.change == 1) {
					return true;
				}
				queue.offer(new Node(n.r + dr[0], n.c + dc[0], 0, 1, 1));
				continue;
			}

			queue.offer(new Node(n.r + dr[n.dir], n.c + dc[n.dir], n.dir, n.move + 1, n.change));
		}

		return true;
	}
}