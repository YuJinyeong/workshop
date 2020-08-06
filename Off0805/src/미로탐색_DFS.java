import java.util.Scanner;

// 일반적으로 최단거리 : BFS
//			경우의 수: DFS

// 이 문제는 DFS로 풀면 시간 초과 난다

// 백준 Q.2178 미로탐색
public class 미로탐색_DFS {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	// 각 상태가 가져야되는 정보는 어디 있는지(행,열) 그리고 몇칸이나 왔는지 cnt
	static void go(int r, int c, int cnt) {
		// 기저파트: 목적지에 도달
		if (r == N && c == M) {
			ans = Math.min(ans, cnt);
			return;
		}
		// 다음 상태에 대한 유도파트. 상하좌우 중 이동가능한 곳
		// 모든 후보 == 모든 방향
		for(int d=0; d<4; d++) {
			// 그 중에서 갈 수 있는 곳(나가는 건 검사 안해도 ㄱㅊ 0으로 padding 해놔서)
			// 벽이 아닌 곳
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 다음 위치가 벽인 곳은 가지 말자
			if(map[nr][nc] == 0)
				continue;
			if(visited[nr][nc])
				continue;
			visited[nr][nc] = true;
			go(nr, nc, cnt+1);
			visited[nr][nc] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		for(int i=1; i<N+1; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j+1] = str.charAt(j) - '0';
			}
		}
		ans = 987654321;
		go(1, 1, 1); // 1,1 위치에서 카운트 1인 상태로 출발
		System.out.println(ans);
	}

}
