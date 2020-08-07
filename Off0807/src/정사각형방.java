import java.util.Scanner;

public class 정사각형방 {

	// 맵 안에 숫자는 1부터 N^2까지의 숫자이기 때문에
	// 0이라는 숫자는 어떤 숫자보다도 +1 이 숫자가 될 수 없음
	// 맵을 2칸 더 크게 만들면.. 범위 검사를 하지 않아도 알아서 못가는 곳으로 테두리가 막혀있을 것

	static int N;
	static int[][] map;
	static Ans result;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 정답 클래스 정의
	// 출발 위치. 이동 칸 수. 에 대한 정보를 담을 수 있는 클래스

	static class Ans implements Comparable<Ans> {
		int pos;
		int cnt;

		Ans(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Ans o) {
			// cnt가 큰 객체로 정렬
			if (this.cnt == o.cnt)
				return this.pos - o.pos;
			return o.cnt - this.cnt;
		}

		@Override
		public String toString() {
			return this.pos + " " + this.cnt;
		}
	}

	static void dfs(int r, int c, int start, int cnt) {
		// 현재 상태가 알고 있는 정답보다 좋다면 갱신
		Ans ans = new Ans(start, cnt);
		if (result.compareTo(ans) > 0)
			result = ans;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (map[nr][nc] == map[r][c] + 1)
				dfs(nr, nc, start, cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T + 1; tc++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			result = new Ans(987654321, 0);
			// 모든 위치에서 dfs를 돌려본다.
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++)
					dfs(i, j, map[i][j], 1);
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
