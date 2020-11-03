import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준3190뱀 {
	static int N, map[][], K, answer, head[], dir[], L, X, nr, nc;
	static final int APPLE = 1;
	static final int SNAKE = 2;
	static Queue<int[]> sq;
	static char C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		K = Integer.parseInt(in.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = APPLE;
		}

		answer = 0;
		map[0][0] = SNAKE;
		head = new int[] {0, 0};
		dir = new int[] {0, 1};
		sq = new LinkedList<>();
		sq.add(head);
		
		L = Integer.parseInt(in.readLine());
		X = -1;
		C = 0;
		boolean fin = false;
		
//		print(map, answer);
		
		out:for(int l=0; l<L; l++) {
			st = new StringTokenizer(in.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			C = st.nextToken().charAt(0); //'L'이면 왼쪽으로 'D'면 오른쪽으로 90 회전
			
//			System.out.println(X + "초 후 " + C + "로 회전");
			
			
			//머리 이동
			for(int i=answer+1; i<=X; i++) {
				answer++;
				if(!moveHead()) {
					fin = true;
					break out;
				}
			}
			
			//방향 전환
			dir = changeDir();
//			System.out.println(Arrays.toString(dir) + "으로 방향 전환");
			
		}
		
		if(!fin) {
			//부딪힐때까지 직진
			while(true) {
				answer++;
				if(!moveHead())
					break;
			}
		}
		
//		print(map, answer);
		System.out.println(answer);
	}

	private static boolean moveHead() {
		nr = head[0] + dir[0];
		nc = head[1] + dir[1];
		
//		System.out.println("머리 이동: " + nr + ", " + nc);
		
		//벽에 부딪히거나 자신의 몸에 부딪히면 탈락
		if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]==SNAKE)
			return false;
		
		//만약에 움직인 칸에 사과가 없다면 꼬리 제거
		if(map[nr][nc] != APPLE) {
			int[] d = sq.poll();
			map[d[0]][d[1]] = 0;
		}

		head = new int[] {nr, nc};
		sq.add(head);
		map[nr][nc] = SNAKE;

//		print(map, answer);
		
		return true;
	}

//	private static void print(int[][] map, int answer) {
//		System.out.println(">>>>>>>>>>>>>>>>>>" + answer+ ">>>>>>>>>>>>>>>");
//		for(int i=0; i<map.length; i++) {
//			for(int j=0; j<map.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

	private static int[] changeDir() {
		if(dir[0]==0 && dir[1]==1) {
			if(C=='L') return new int[] {-1, 0};
			else return new int[] {1, 0};
		}else if(dir[0]==0 && dir[1]==-1) {
			if(C=='L') return new int[] {1, 0};
			else return new int[] {-1, 0};
		}else if(dir[0]==1 && dir[1]==0) {
			if(C=='L') return new int[] {0, 1};
			else return new int[] {0, -1};
		}else {
			if(C=='L') return new int[] {0, -1};
			else return new int[] {0, 1};
		}
	}

}
