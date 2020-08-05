import java.util.Scanner;

// 백준 Q.4963 섬의 개수

// 1을 발견하면 카운트 하나 세고
// 그 로부터 팔방에 1이 있으면 0으로 바꾸자
// 그 로부터 또 다시 팔방에 1이 있으면 0으로 바꾸자
// ...계속 반복...

public class 섬의개수_DFS {
	// 12시부터 시계방향으로 8방
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[][] map;
	static int W, H; // W가로, H세로

	static void dfs(int r, int c) {
		map[r][c] = 0;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 밖으로 나가는건 패스
			if (nr < 0 || nc < 0 || nr >= H || nc >= W)
				continue;
			// 바다도 패스
			if (map[nr][nc] == 0)
				continue;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0)
				break;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			}
			
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}

	}
}
