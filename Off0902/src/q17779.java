import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Q.17779 게리맨더링2
public class q17779 {
	static int[][] map, pop; // 구역, 인구
	static int[] total;
	static int N, ans, sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		pop = new int[N][N];
		map = new int[N][N];
		
		sum = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				pop[i][j] = Integer.parseInt(st.nextToken());
				sum += pop[i][j];
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 기준점이 정해짐
				for(int d1=1; d1<N; d1++) {
					for(int d2=1; d2<N; d2++) {
						// 경계의 길이가 정해짐
						if(i+d1+d2<N && j-d1>=0 && j+d2<N) {
							div(i, j, d1, d2);
						}
					}
				}
			}
		}
		
//		printst();
		System.out.println(ans);
	}
	
//	private static void printst() {
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

	private static void div(int x, int y, int d1, int d2) {
		map = new int[N][N];
		total = new int[5];
		
		// 5구역
		for(int i=0; i<=d1; i++) {
			map[x+i][y-i] = 5;
			map[x+d2+i][y+d2-i] = 5;
		}
		for(int i=1; i<=d2; i++) {
			map[x+i][y+i] = 5;
			map[x+d1+i][y-d1+i] = 5;
		}
		
		// 나머지 구역
		for(int i=0; i<x+d1; i++) {
			for(int j=0; j<=y; j++) {
				if(map[i][j] == 5) break;
				map[i][j] = 1;
				total[1] += pop[i][j];
			}
		}
		
		for(int i=0; i<=x+d2; i++) {
			for(int j=N-1; j>=y+1; j--) {
				if(map[i][j] == 5) break;
				map[i][j] = 2;
				total[2] += pop[i][j];
			}
		}
		
		for(int i=x+d1; i<N; i++) {
			for(int j=0; j<y-d1+d2; j++) {
				if(map[i][j] == 5) break;
				map[i][j] = 3;
				total[3] += pop[i][j];
			}
		}
		
		for(int i=x+d2+1; i<N; i++) {
			for(int j=N-1; j>=y-d1+d2; j--) {
				if(map[i][j] == 5) break;
				map[i][j] = 4;
				total[4] += pop[i][j];
			}
		}
		
		total[0] = sum - total[1] - total[2] - total[3] - total[4];
		Arrays.sort(total);
		int sub = total[4] - total[0];
//		System.out.println(Arrays.toString(total) + sub);
		ans = Math.min(ans, sub);
	}

}
