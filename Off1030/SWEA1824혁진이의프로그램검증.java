import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1824혁진이의프로그램검증 {
	static int T, R, C;
	static char[][] map;
	static boolean[][][][] check;
	
	// 상 하 좌 우
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int UP = 0;
	static final int DN = 1;
	static final int LT = 2;
	static final int RT = 3;

	static class Point {
		int r, c, v, d;

		Point(int r, int c, int v, int d) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", v=" + v + ", d=" + d + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		boolean answer = false;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			check = new boolean[R][C][16][4];

			boolean pos = false;
			for (int r = 0; r < R; r++) {
				String str = in.readLine();
				map[r] = str.toCharArray();
				if(str.contains("@")) {
					pos = true;
				}
			}
			
//			for (int r = 0; r < R; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
			
			
			if(!pos) {
				System.out.println("#" + tc + " NO");
				continue;
			}
			
			Queue<Point> qu = new LinkedList<>();
			qu.offer(new Point(0, 0, 0, 3));
			while (!qu.isEmpty()) {
				Point cur = qu.poll();
				int d = cur.d;
				int v = cur.v;
//				System.out.println(cur.toString());
				
				char c = map[cur.r][cur.c];
				
				if (c == '@') {
					answer = true;
					break;
				}
				
				// 메모리 값 수정
				if ((c >= '0' && c <= '9') || c == '+' || c == '-')
					v = changeVal(c, v);
				
				// 방향 수정
				else if(c == '?') {
					for(int i=0; i<4; i++) {
						d = i;
						Point nxt = new Point((cur.r + deltas[d][0])%R, (cur.c + deltas[d][1])%C, v, d);
						if(check[nxt.r][nxt.c][nxt.v][nxt.d])
							continue;
						check[nxt.r][nxt.c][nxt.v][nxt.d] = true;
						qu.offer(nxt);
					}
					continue;
				}
				
				if (c == '<') {
					d = LT;
				} else if (c == '>') {
					d = RT;
				} else if (c == '^') {
					d = UP;
				} else if (c == 'v') {
					d = DN;
				}else if(c == '_') {
					if(v == 0) d = RT;
					else d = LT;
				}else if(c == '|') {
					if(v == 0) d = DN;
					else d = UP;
				}
				
				Point nxt = new Point((cur.r + deltas[cur.d][0])%R, (cur.c + deltas[cur.d][1])%C, v, d);
				
				if(check[nxt.r][nxt.c][nxt.v][nxt.d]) {
					answer = false;
					continue;
				}
				
				check[nxt.r][nxt.c][nxt.v][nxt.d] = true;
				qu.offer(nxt);
			}

			System.out.println("#" + tc + " " + (answer ? "YES" : "NO"));
		}
	}

	private static int changeVal(char c, int value) {
		if (c == '+') {
			if (value == 15)
				value = 0;
			else
				value++;
		} else if (c == '-') {
			if (value == 0)
				value = 15;
			else
				value--;
		} else if (c >= '0' && c <= '9') {
			// 숫자일때
			value = c - '0';
		}
		return value;
	}

}
