import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6109추억의2048게임_조 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	static int T;
	static int N;
	static String dir;
	static int[][] map;
	
	//사방으로 밀 수 있다.
	//상:0, 하:1, 좌:2, 우:3
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	//합쳐진 노드는 움직일 수 없다 -->  visited 개념
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		output = new StringBuilder();
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			dir = tokens.nextToken();
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}//입력 완료
//			for(int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			if(dir.equals("up")) {
				for(int c=0; c<N; c++) {
					for(int r=1; r<N; r++) {
						move(r, c, 0);
					}
				}
			}else if(dir.equals("down")) {
				for(int c=0; c<N; c++) {
					for(int r=N-2; r>=0; r--) {
						move(r, c, 1);
					}
				}
			}else if(dir.equals("left")) {
				for(int r=0; r<N; r++) {
					for(int c=1; c<N; c++) {
						move(r, c, 2);
					}
				}
			}else {
				for(int r=0; r<N; r++) {
					for(int c=N-2; c>=0; c--) {
						move(r, c, 3);
					}
				}
			}//이동 종료
			output.append("#").append(t).append("\n");
			for(int[] row: map) {
				for(int i: row) {
					output.append(i).append(" ");
				}
				output.append("\n");
			}
		}
		System.out.println(output.toString());
	}
	
	static void move(int r, int c, int d) {
		//다음 지점 고민
		int nr = r + deltas[d][0];
		int nc = c + deltas[d][1];
		
		//탈출조건: 새로운 지점이 범위를 벗어나거나 기존 점, 새 점이 고정된 경우는 그만
		if(!isIn(nr, nc) || visited[nr][nc] || visited[r][c])
			return;
		
		//사용 - 이동하려는 지점의 좌표에 따라 다르게 동작
		//0이면 비어있는 경우 --> 이동
		if(map[nr][nc] == 0) {
			map[nr][nc] = map[r][c];
			map[r][c] = 0;
		}
		
		//대상 지점의 값이 나와 같다면: 묻고 더블로 가!
		else if(map[nr][nc] == map[r][c]) {
			map[nr][nc] *= 2;
			map[r][c] = 0;
			//합쳐진 경우는 이동 불가 --> visited에 표시해주자
			visited[nr][nc] = true;
		}
		
		//할 일 없음
		else {
			
		}
		
		//다음 재귀
		move(nr, nc, d);
	}
	
	static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static String src = "2\r\n" + 
			"5 up\r\n" + 
			"4 8 2 4 0\r\n" + 
			"4 4 2 0 8\r\n" + 
			"8 0 2 4 4\r\n" + 
			"2 2 2 2 8\r\n" + 
			"0 2 2 0 0\r\n" + 
			"2 down\r\n" + 
			"16 2\r\n" + 
			"0 2";
}
