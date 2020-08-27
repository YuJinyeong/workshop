import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1600 {
	static class Status {
		int r;
		int c;
		int cnt;
		int jump;

		Status() {
		}

		Status(int r, int c, int cnt, int jump) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.jump = jump;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int map[][] = new int[H][W];
		boolean visited[][][] = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };
		int hr[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int hc[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

		int ans = -1;
		Queue<Status> qu = new LinkedList<>();
		visited[0][0][0] = true;
		qu.add(new Status(0, 0, 0, 0));
		while (!qu.isEmpty()) {
			Status s = qu.poll();

			if (s.r == H - 1 && s.c == W - 1) {
				ans = s.cnt;
				break;
			}

			if (s.jump < K) {
				for (int h = 0; h < 8; h++) {
					int hnr = s.r + hr[h];
					int hnc = s.c + hc[h];

					if (hnr < 0 || hnc < 0 || hnr >= H || hnc >= W || map[hnr][hnc] == 1)
						continue;

					if (visited[hnr][hnc][s.jump+1])
						continue;

					visited[hnr][hnc][s.jump+1] = true;
					qu.add(new Status(hnr, hnc, s.cnt + 1, s.jump + 1));

				}
			}

			for (int d = 0; d < 4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == 1)
					continue;

				if (visited[nr][nc][s.jump])
					continue;

				visited[nr][nc][s.jump] = true;
				qu.add(new Status(nr, nc, s.cnt + 1, s.jump));

			}

		}
		System.out.println(ans);
	}

}
