import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class πÈ¡ÿ2239Ω∫µµƒÌ {
	static int[][] board;
	static boolean flag, check[], check_v[][], check_h[][], check_s[][][];
	static List<int[]> zeros;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		check_v = new boolean[9][10];
		check_h = new boolean[9][10];
		check_s = new boolean[3][3][10];
		zeros = new ArrayList<>();
		flag = false;

		for (int i = 0; i < 9; i++) {
			String str = in.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = str.charAt(j) - '0';
				if (board[i][j] > 0) {
					check_v[j][ board[i][j] ] = true;
					check_h[i][ board[i][j] ] = true;
					check_s[i / 3][j / 3][board[i][j]] = true;
				} else {
					zeros.add(new int[] { i, j });
				}
			}
		}

		go(0);
	}

	
	private static void go(int idx) {
		if(flag) return;
		
		if(idx >= zeros.size() ) {
			flag = true;
			print();
			return;
		}
		
		int[] cur = zeros.get(idx);
		int i = cur[0];
		int j = cur[1];
		for (int a = 1; a < 10; a++) {
			if (!check_v[j][a] && !check_h[i][a] && !check_s[i / 3][j / 3][a]) {
				board[i][j] = a;
				check_v[j][a] = true;
				check_h[i][a] = true;
				check_s[i / 3][j / 3][a] = true;
				go(idx+1);				
				check_v[j][a] = false;
				check_h[i][a] = false;
				check_s[i / 3][j / 3][a] = false;
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
