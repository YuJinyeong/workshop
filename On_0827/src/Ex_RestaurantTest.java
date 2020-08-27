import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_RestaurantTest {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		makePipe();
		System.out.println(cnt);
	}
	
	private static void makePipe() {
		cnt = 0;
		// 0열의 나기부씨 식당의 모든 행의 위치에서 파이프 놓기 시작
		for(int r=0; r<R; r++) {
			visited[r][0] = true;
			go(r, 0);
		}
	}
	
	static int[] dr = {-1, 0, 1};
	// 현 위치에서 오른쪽 대각선 위(-1, 1), 오른쪽(0, 1), 오른쪽 대각선 아래(1, 1) 순서적으로 파이프 연결 시도
	private static boolean go(int r, int c) {
		if(c == C - 1) { //나야나씨 식당까지 파이프가 연결된 상황
			++cnt;
			return true; // 성공했다는 결과를 리턴
		}
		
		int nr, nc = c+1;
		// 현 위치에서 오른쪽 대각선 위(-1, 1), 오른쪽(0, 1), 오른쪽 대각선 아래(1, 1) 순서적으로 파이프 연결 시도
		for(int d=0; d<3; d++) {
			nr = r + dr[d];
			
			if(nr<0 || nr>=R || visited[nr][nc] || map[nr][nc]=='x') continue;
			
			visited[nr][nc] = true;// 파이프 놓기
			if(go(nr, nc)) return true;	// 다음 칸으로 이동후 진행 결과가 끝까지 연결이 가능했다면
										// 현 위치에서 다른 방향으로 파이프 놓기 시도를 중단하고 이전 위치로 돌아감
		}
		return false;
	}
}
