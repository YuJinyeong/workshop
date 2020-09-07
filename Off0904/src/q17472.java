import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17472 {
	static int N, M;
	static int[][] map;
	static int I;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(st.nextToken());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr<0 || nc<0 || nr>=N || nc>=M)
							continue;
						
						if(map[nr][nc] == 0) {
							int nnr = nr;
							int nnc = nc;
							while(map[nnr][nnc] == 0) {
								
							}
						}
					}
				}
			}
		}
	}

}
