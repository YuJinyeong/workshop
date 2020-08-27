import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1987 {
	static int R, C, cnt, ans;
	static char[][] board;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		visited = new boolean[26];
		
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		cnt = 1;
		ans = 1;
		go(0, 0);
		System.out.println(ans);
	}

	private static void go(int r, int c) {
		char ch = board[r][c];
		visited[ch - 'A'] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C)
				continue;
			
			if(visited[board[nr][nc]-'A'] == true)
				continue;
			
			ans = Math.max(ans, ++cnt);
			go(nr, nc);
		}
		cnt--;
		visited[ch-'A'] = false;
	}

}
