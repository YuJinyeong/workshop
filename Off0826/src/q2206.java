import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2206 {
	static class point {
		int r;
		int c;
		int cnt;
		int sum;

		point() {
		}

		point(int r, int c, int sum, int cnt) {
			this.r = r;
			this.c = c;
			this.sum = sum;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int ans = 123456789;

		Queue<point> qu = new LinkedList<>();
		qu.add(new point(0, 0, 0, 1));
		while (!qu.isEmpty()) {
			point p = qu.poll();
			if(visited[p.r][p.c][p.sum] == true) continue;
			visited[p.r][p.c][p.sum] = true;
			
			if (p.cnt >= ans)
				continue;

			if (p.r == N - 1 && p.c == M - 1) {
				ans = Math.min(p.cnt, ans);
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc][p.sum] == true)
					continue;

				if (map[nr][nc] == '0') {
					qu.add(new point(nr, nc, p.sum, p.cnt + 1));
				}
				else if (map[nr][nc] == '1' && p.sum == 0) {
					qu.add(new point(nr, nc, p.sum + 1, p.cnt + 1));
				}
			}
		}
		if(ans == 123456789) ans = -1;
		System.out.println(ans);
	}
}
