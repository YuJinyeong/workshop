import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//맵의 크기를 입력받고
		int N = sc.nextInt();
		//정해진 크기로 맵을 표현할 2차원배열을 생성
		int[][] map = new int[N][N];
		int max = 0;
		//맵을 입력받으면서 가장 큰 숫자를 기억.
		//( 전체 날짜는 100일까지 있지만. 지대가 가장 높은 아이가 20 이라면 20까지만 해보면됨 )
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		int result = 1;
		//지대가 1까지 물에잠긴경우. 2까지 잠긴경우. 3까지 잠긴경우. ... 젤 높은곳까지 다 잠긴경우
		for(int i = 1; i <= max; i++) {
			// i 높이까지 잠겼을때 i보다 넓은 곳의 영역을 센다.
			boolean[][] visited = new boolean[N][N];
			Queue<Node> queue = new LinkedList<>();
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					//아직 세지 않았으면서, 기준 i보다 지대가 높다면
					//(육지이지만 아직 처리하지 않은 육지)
					if(map[j][k] > i && !visited[j][k]) {
						//해당 육지를 센거로 체크하고 큐에 담는다.
						visited[j][k] = true;
						queue.add(new Node(j,k));
						//큐가 빌때까지
						while(!queue.isEmpty()) {
							Node n = queue.poll();
							//사방으로 연결된 곳을
							for(int d = 0; d < 4; d++) {
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];
								//밖으로 나가지 않고.
								if( nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length) {
									//육지이면서 아직 처리되지 않았다면
									if(map[nr][nc] > i && !visited[nr][nc]) {
										//큐삽입
										visited[nr][nc] = true;
										queue.add(new Node(nr,nc));
									}
								}
							}
						}
						// 이 한덩어리에 대해서 카운트
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
}