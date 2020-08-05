import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 Q.2178 미로탐색
public class 미로탐색_BFS {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static class Status {
		int r, c, cnt;

		public Status(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
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
		
		// 큐를 준비한다.
		Queue<Status> queue = new LinkedList<>();
		// 시작 상태에 대한 정보를 큐에 넣는다.
		queue.add(new Status(1, 1, 1));
		// 해당 상태에 대해 방문체크를 한다.
		visited[1][1] = true;
		
		// 큐가 빌때까지
		while(!queue.isEmpty()) {
		// 큐에서 하나 꺼내서. 정답이 나오면 그만.
			Status s = queue.poll();
			if(s.r == N && s.c == M) {
				System.out.println(s.cnt);
				break;
			}
		// 정답이 아니면, 다음 상태에 대해서 큐에 삽입하고 방문 check
			for(int d=0; d<4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				// 벽이면 넘어감
				if(map[nr][nc] == 0)
					continue;
				// 갔던 곳이면 넘어감
				if(visited[nr][nc])
					continue;
				queue.add(new Status(nr, nc, s.cnt+1));
				visited[nr][nc] = true;
			}
		}
	}

}
