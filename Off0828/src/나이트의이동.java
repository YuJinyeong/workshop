import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
	static class Point {
		int r, c, cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[] dr = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int[] dc = { -1, 1, -1, 1, -2, 2, -2, 2 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int l = sc.nextInt();// 4 ≤ l ≤ 300;
			visited = new boolean[l][l];
			Point start = new Point(sc.nextInt(), sc.nextInt(), 0);
			Point dest = new Point(sc.nextInt(), sc.nextInt(), 0);
			Queue<Point> queue = new LinkedList<>();
			visited[start.r][start.c] = true;
			queue.add(start);
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				if (p.r == dest.r && p.c == dest.c) {
					System.out.println(p.cnt);
					break;
				}
				for (int d = 0; d < 8; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= l || nc >= l)
						continue;
					if (visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, p.cnt + 1));
				}
			}
		}
	}
}
