import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1949. [모의 SW 역량테스트] 등산로 조성 
public class q1949 {
	static int N, K, map[][], ans;
	static boolean flag, check[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			check = new boolean[N][N];
			flag = false;
			ans = 0;
			
			int max = 0;
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(max < map[r][c]) max = map[r][c];
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(max == map[r][c]) {
						check[r][c] = true;
//						System.out.println();
						dfs(r, c, max, 1);
						check[r][c] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
		
	}

	private static void dfs(int r, int c, int h, int res) {
//		System.out.print(res + "(" + r + ", " + c + "):" + h + " - ");
		ans = Math.max(res, ans);
		int nr=0, nc=0;
		
		for(int d=0; d<4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N || check[nr][nc])
				continue;
			
			if(map[nr][nc] < h) {
				check[nr][nc] = true;
				dfs(nr, nc, map[nr][nc], res+1);
				check[nr][nc] = false;
			}
			
			else if(!flag && map[nr][nc]-K < h) {
				flag = true;
				check[nr][nc] = true;
				dfs(nr, nc, h-1, res+1);
				check[nr][nc] = false;
				flag = false;
			}
		}
	}
}
