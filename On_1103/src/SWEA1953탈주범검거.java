import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953탈주범검거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int N, M, R, C, L, map[][], answer;
		boolean[][] check;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[] rd = {1, 0, 3, 2};
		boolean[][] connect = {{false, false, false, false},
								{true, true, true, true},
								{true, true, false, false},
								{false, false, true, true},
								{true, false, false, true},
								{false,true, false, true},
								{false, true, true, false},
								{true, false, true, false}};
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			check = new boolean[N][M];
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int m=0; m<M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 1;
			if(L > 1) {
				check[R][C] = true;
				Queue<int[]> qu = new LinkedList<>();
				qu.offer(new int[] {R, C, 1});
				
				int cur[], dir, nr, nc;
				while(!qu.isEmpty()) {
					cur = qu.poll();
					
					dir = map[cur[0]][cur[1]];
					for(int d=0; d<4; d++) {
						nr = cur[0] + dr[d];
						nc = cur[1] + dc[d];
						
						if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]==0 || check[nr][nc] || !connect[dir][d] || !connect[map[nr][nc]][rd[d]])
							continue;
						
						check[nr][nc] = true;
						answer++;
						if(cur[2]+1 < L) qu.add(new int[] {nr, nc, cur[2] + 1});
					}
					//print(check, N, M);
				}
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}

//	private static void print(boolean[][] check, int N, int M) {
//		System.out.println();
//		for(int n=0; n<N; n++) {
//			for(int m=0; m<M; m++) {
//				System.out.print(check[n][m] + " ");
//			}
//			System.out.println();
//		}
//	}
}
