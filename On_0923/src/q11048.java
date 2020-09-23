import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] candy = new int[N][M];
		int[] dr = { 0, 1, 1 };
		int[] dc = { 1, 1, 0 };

		candy[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int c = candy[i][j];
				for(int d=0; d<3; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr>=N || nc>=M)	continue;
					
					if(candy[nr][nc]==0)
						candy[nr][nc] = map[nr][nc] + c;
					else 
						candy[nr][nc] = Math.max(map[nr][nc]+c, candy[nr][nc]);
				}
				
			}
		}
		
		System.out.println(candy[N-1][M-1]);
	}
}
