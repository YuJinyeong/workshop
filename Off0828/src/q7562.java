import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 - Q.7562 나이트의 이동
public class q7562 {
	static int[] dr = { 1, -1, 2, -2, 2, -2, 1, -1 };
	static int[] dc = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int N = sc.nextInt();
			map = new int[N][N];
			int rr = sc.nextInt();
			int cc = sc.nextInt();
			map[sc.nextInt()][sc.nextInt()] = 1;
			System.out.println(go(map, rr, cc));
		}
	}

	private static int go(int[][] map, int r, int c) {

		if(map[r][c] == 1)
			return 0;
		
		int N = map.length;
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] {r, c, 0});
		int cnt = 0;
		
		L: while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			map[cur[0]][cur[1]] = 2;
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int ncnt = cur[2] + 1;
				
				// 배열의 범위를 벗어나면 탈락
				if(nr<0 || nc<0 || nr>=N || nc>=N)
					continue;
				
				// 도착지점에 도착
				if(map[nr][nc] == 1) {
					cnt = ncnt;
					break L;
				}
				
				// 전에 방문했으면 탈락
				if(map[nr][nc] != 0)
					continue;
				
				map[nr][nc] = 2;
				qu.add(new int[] {nr, nc, ncnt});
			}
		}
		return cnt;
	}
}
