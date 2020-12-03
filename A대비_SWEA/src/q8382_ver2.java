import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//8382. 방향 전환
public class q8382_ver2 {
	static int x1, y1, x2, y2;
	static final int HOR=0, VER=1;	// 000001	1^1
									// 000001
									// 000000
	static int [][][] dir = {
			{{-1, 0}, {1, 0}}, 	//hor:0
			{{0, -1}, {0, 1}} 	//ver:1
	};
	
	static class Point{
		int x, y, d, cnt; //x좌표, y좌표, 이동방향, 이동횟수
		
		public Point(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			//좌표에 100씩 더해 음수좌표 보정
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
					
			System.out.println("#" + tc + " " + bfs());
		}
	}
	
	private static int bfs() {
		Queue<Point> qu = new LinkedList<q8382_ver2.Point>();
		boolean[][][] visited = new boolean[2][201][201];
		
		visited[HOR][x1][y1] = true;
		qu.offer(new Point(x1, y1, HOR, 0));
		visited[VER][x1][y1] = true;
		qu.offer(new Point(x1, y1, VER, 0));
		
		Point cur;
		int nx, ny;
		while(!qu.isEmpty()) {
			cur = qu.poll();
			
			if(cur.x == x2 && cur.y == y2) return cur.cnt;
			
			int[][] d= dir[cur.d^1]; // 현재 좌표 방향의 반대에 해당하는 델타값
			for(int i=0; i<d.length; i++) {
				nx = cur.x + d[i][0];
				ny = cur.y + d[i][1];
				if(nx>=0 && nx<=200 && ny>=0 && ny<=200 && !visited[cur.d^1][nx][ny]) {
					visited[cur.d^1][nx][ny] = true;
					qu.offer(new Point(nx, ny, cur.d^1, cur.cnt+1));
				}
			}
		}
		return 0;
	}
}
