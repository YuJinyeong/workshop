import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA6109추억의2048게임 {
	static int T, N, board[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			board = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Integer> qu;
			if("left".equals(dir)) {
				for(int i=0; i<N; i++) {
					qu = new LinkedList<>();
					for(int j=0; j<N; j++) {
						if(board[i][j] != 0)
							qu.add(board[i][j]);
						board[i][j] = 0;
					}
					if(qu.isEmpty()) continue;
					int j = 0;
					int num = qu.poll();
					board[i][j] = num;
					while(!qu.isEmpty()) {
						int nxt = qu.poll();
						if(num == nxt) {
							board[i][j] += num;
							num = 1;
						}else {
							board[i][++j] = nxt;
							num = nxt;
						}
					}
				}
			}else if("right".equals(dir)) {
				for(int i=0; i<N; i++) {
					qu = new LinkedList<>();
					for(int j=N-1; j>=0; j--) {
						if(board[i][j] != 0)
							qu.add(board[i][j]);
						board[i][j] = 0;
					}
					if(qu.isEmpty()) continue;
					int j = N-1;
					int num = qu.poll();
					board[i][j] = num;
					while(!qu.isEmpty()) {
						int nxt = qu.poll();
						if(num == nxt) {
							board[i][j] += num;
							num = 1;
						}else {
							board[i][--j] = nxt;
							num = nxt;
						}
					}
				}
			}else if("up".equals(dir)) {
				for(int i=0; i<N; i++) {
					qu = new LinkedList<>();
					for(int j=0; j<N; j++) {
						if(board[j][i] != 0) 
							qu.add(board[j][i]);
						board[j][i] = 0;
					}
					if(qu.isEmpty()) continue;
					int j = 0;
					int num = qu.poll();
					board[j][i] = num;
					
					while(!qu.isEmpty()) {
						int nxt = qu.poll();
						if(num == nxt) {
							board[j][i] += num;
							num = 1;
						}else {
							board[++j][i] = nxt;
							num = nxt;
						}
					}
				}
			}else if("down".equals(dir)) {
				for(int i=0; i<N; i++) {
					qu = new LinkedList<>();
					for(int j=N-1; j>=0; j--) {
						if(board[j][i] != 0)
							qu.add(board[j][i]);
						board[j][i] = 0;
					}
					if(qu.isEmpty()) continue;
					int j = N-1;
					int num = qu.poll();
					board[j][i] = num;
					while(!qu.isEmpty()) {
						int nxt = qu.poll();
						if(num == nxt) {
							board[j][i] += num;
							num = 1;
						}else {
							board[--j][i] = nxt;
							num = nxt;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " ");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
