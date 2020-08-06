import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 Q.2667 단지번호붙이기
public class 단지번호붙이기 {
	static class Node {
		int r;
		int c;
		int cnt;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
				
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int cnt = 0, add = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i, j));

					while (!queue.isEmpty()) {
						Node n = queue.poll();
						add = cnt + 1;

						for (int k = 0; k < 4; k++) {
							int nr = n.r + dr[k];
							int nc = n.c + dc[k];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							if (map[nr][nc] != 1)
								continue;

							map[nr][nc] = add;
							queue.add(new Node(nr, nc));
						}
					}
				}

			}
		}

		System.out.println(cnt);
		int[] count = new int[cnt]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.print(map[i][j] + " ");
				if(map[i][j] != 0) {
					count[map[i][j]-2] ++;
				}
			}
		}
		Arrays.sort(count);
		for(int i=0; i<count.length; i++)
			System.out.println(count[i]);
	}

}
