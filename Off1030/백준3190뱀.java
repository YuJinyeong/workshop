import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준3190뱀 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N; //보드의 크기
	static int K; //사과의 크기
	
	static int[][] map;
	static int L; //회전 정보
	//회전 정보를 저장할  map
	static Map<Integer, String> turnMap = new HashMap<>();
	//이동 방향에 따른 좌표 설정
	// N = 0, E = 1, S = 2, W = 3
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		
		map = new int[N+1][N+1]; //인덱스 조절
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 1;
		}
		
		//회전 정보 처리
		L = Integer.parseInt(input.readLine());
		for(int l=0; l<L; l++) {
			tokens = new StringTokenizer(input.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			turnMap.put(t, tokens.nextToken());
		}
		
//		for(int[] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("회전정보" + turnMap);
		
		Snake snake = new Snake();
		int time = 0;
		while(true) {
			boolean result = snake.move(turnMap.get(time));
			time++;
			if(!result) break;
		}
		System.out.println(time);
	}
	
	static class Point{
		int row, col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		//Queue에 포함되어 있는지 확인하기 위해
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
	
	static class Snake{
		//몸통 관리를 위해서 방문한 지점들을   Queue에 넣어주자
		Queue<Point> body = new LinkedList<>();
		
		//방향 회전을 위한 변수 선언
		int N = 0, E = 1, S = 2, W = 3;
		
		//초기 방향
		int dir = E;
		//초기 위치, 뱀의 시작점
		Point head = new Point(1, 1);
		
		public Snake() {
			body.offer(head);
		}
		
		public boolean move(String d) {
			// 방향 정보 보정
			//d가 null이면 보정할 필요가 없고, null이 아니라면 보정
			if(d!=null) {
				if(d.equals("D")) {//시계 방향으로 회전
					 dir++;
					 if(dir==4) dir=N;
				}else if(d.equals("L")) {//반시계 방향으로 회전
					dir--;
					if(dir==-1) dir=W;
				}
			}
			//방향 결정 완료 --> 이제 머리가 이동해본다.
			Point newHead = new Point(head.row + deltas[dir][0], head.col + deltas[dir][1]);
			//종료되는 기준은 2개 : 새로운 머리가 범위를 벗어나거나, 기존 몸통의 일부라면 그만
			//범위를 벗어나는 경우
			if(!isIn(newHead.row, newHead.col))
				return false;
			//이미 포함된 경우
			else if(body.contains(newHead)) {
				return false;
			}
			//그렇지 않다면.. 새로운 머리를 포함해주고 이동
			else {
				body.add(newHead);
				head = newHead;
				
				//이동 지점에 사과가 있는지 여부에 따라 꼬리를 제거할지 결정
				//사과 없음 --> 맨 처음 넣은 녀석 제거
				if(map[head.row][head.col]==0) {
					body.poll();
				}
				//그렇지 않다면 --> 사과. 먹고 커지자.. --> 유지
				else {
					map[head.row][head.col] = 0;
				}
				return true;
			}
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r>=1 && c>=1 && r<=N && c<=N;
	}
	
	static String src = "10\r\n" + 
			"5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"1 2\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
	
}
