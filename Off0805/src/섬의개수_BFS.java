import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의개수_BFS {
	// 12시부터 시계방향으로 8방
		static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		static int[][] map;
		static int W, H; // W가로, H세로

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
						// 큐를 만들어서.. 해당 위치를 삽입.
						Queue<Node> queue = new LinkedList<>();
						queue.add(new Node(i, j));
						// 큐가 빌 때까지
						while(!queue.isEmpty()) {
							// 꺼내서 바다로 만들고 8방에 1이 존재한다면 큐에 삽입
							Node n = queue.poll();
							map[n.r][n.c] = 0;
							for(int d = 0; d<8; d++) {
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];
								
								// 밖으로 나가는건 패스
								if (nr < 0 || nc < 0 || nr >= H || nc >= W)
									continue;
								// 바다도 패스
								if (map[nr][nc] == 0)
									continue;
								queue.add(new Node(nr, nc));
							}
						}
						
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

}
