import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2_7793_오나의여신님 {
	static char[][] map;
	static boolean[][] visited;
	static int N, M, ans, cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<point> devils;
	static Queue<point> steps;

	static class point {
		int r;
		int c;

		point() {
		}

		point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			devils = new LinkedList<>();
			steps = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						map[i][j] = '.';
						steps.add(new point(i, j));
					} else if (map[i][j] == '*') {
						devils.add(new point(i, j));
					}
				}
			}
			System.out.println("#" + tc + " " + bfs());
		}
	}

	private static String bfs() {
		int dSize, sSize, cnt = 0, ans = -1;
		L: while (true) {
			cnt++;
			// 악마
			dSize = devils.size();
			while (dSize-- > 0) {
				point p = devils.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == '.') {
						devils.add(new point(nr, nc));
						map[nr][nc] = '*';
					}
				}
			}

			// 수연이
			sSize = steps.size();
			if (sSize == 0)
				break;
			while (sSize-- > 0) {
				point p = steps.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr<0 || nc<0 || nr>=N || nc>=M)
						continue;
					if (map[nr][nc] == '.') {
						steps.add(new point(nr, nc));
						map[nr][nc] = 'S';
					}
					else if (map[nr][nc] == 'D') {
						ans = cnt;
						break L;
					}
				}
			}
		}
		return (ans == -1) ? "GAME OVER" : Integer.toString(ans);
	}
}
