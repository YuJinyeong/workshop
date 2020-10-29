import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2636치즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		입력 잘 받았는지 출력해보자
//		for(int[] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
		
	}

	static void bfs() {
		boolean[][] visited = new boolean[R][C];
		// 현재 공기를 탐색해 나갈 녀석
		Queue<Point> q = new LinkedList<>();
		// 다음에 탐색할 대상을 모아 놓을 녀석
		Queue<Point> nextQ = new LinkedList<>();

		// 맨 외곽은 언제나 비어있다.
		Point start = new Point(0, 0);
		visited[0][0] = true;
		q.add(start);

		int time = 0;
		int prev = 0;
		while (true) {
			// 현재 큐에 들어있는 것이 종료될 떄까지..
			while (!q.isEmpty()) {
				// 공기 위주의 탐색, 치즈를 만나면 nextQ에 담기
				Point front = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = front.r + deltas[d][0];
					int nc = front.c + deltas[d][1];

					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						
						// 방문 지점이 공기-->계속 탐색
						if (map[nr][nc] == 0) {
							q.add(new Point(nr, nc));
						}
						
						// 치즈라면? 이번생은 안돼 다음에 꼭 가봐
						else if (map[nr][nc] == 1) {
							nextQ.add(new Point(nr, nc));
						}
					}
				}
			}

			// 다음에 처리할 치즈가 없다면??? 종료
			if (nextQ.isEmpty()) {
				break;
			}

			// 다음에 공기가 될 녀석들을 큐에 담아주자
			q.addAll(nextQ);
			prev = nextQ.size();
			nextQ.clear();

			time++;
		}

		// 총 걸린 시간
		System.out.println(time);
		// 이전 단계의 치즈
		System.out.println(prev);
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static String src = "13 12\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 1 1 1 1 0 1 1 0 0 0\r\n" + "0 1 1 1 1 0 0 1 1 0 0 0\r\n" + "0 0 1 1 0 0 0 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0";
}
