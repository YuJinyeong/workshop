import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Q.17136 색종이 붙이기
public class q17136 {
	static int[][] map;
	static int max;
	static Queue<int[]> qu;
	static boolean[][][] check;

//	static int[] dr = {-1, 1, 0, 0};
//	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		check = new boolean[10][10][6];
		qu = new LinkedList<int[]>();

		max = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					getsize(i, j);
				}
			}
		}

		explore(0, 0);

	}

	private static void explore(int r, int c) {
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			
		}
	}
	

	private static void getsize(int r, int c) {
		int n = 1;

		while (map[r - n][c] == 1 && map[r][c - n] == 1) {
			n++;
		}

		out: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[r-i][c-j] > n)
				map[r-i][c-j] = n;
				if (map[r - i][c - j] == 0) {
					n = 0;
					break out;
				}
			}
		}
		
		if(n == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[r-i][c-j] = 1;
				}
			}
		}
		
	}

}
