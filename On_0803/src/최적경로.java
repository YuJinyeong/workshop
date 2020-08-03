import java.util.Scanner;

public class 최적경로 {
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static Point company;
	static Point home;
	static Point[] customers;
	
	// 먼저 순열을 0부터 N-1까지의 순서에 대해 다 구해두고
	// 순열 구하는 기저파트에서 각 거리를 다 더해서 정답을 찾자.
	static boolean[] check; // 순열에서 중복을 검사하기 위해 이미 사용된 순서인지 여부를 저장할 배열
	static int[] sel; // 뽑아진 순서를 저장할 배열
	static int N, ans;
	static void perm(int idx) {
		if(idx == N) {
			// 회사에서 출발해서 sel에 저장된 순서대로 고객을 방문하고 집으로 이동하는 거리
			Point current = company; // 처음 현재위치는 회사
			int dist = 0;
			// 고객들을 방문한다.
			for(int i=0; i<N; i++) {
				// current에서 customers[sel[i]] 고객까지의 거리
				dist += (Math.abs(current.x - customers[sel[i]].x) + Math.abs(current.y - customers[sel[i]].y));
				current = customers[sel[i]];
			}
			// 마지막 고객을 방문한 위치에서 집까지의 거리를 더한다.
			dist += (Math.abs(current.x - home.x) + Math.abs(current.y - home.y));
			ans = Math.min(ans, dist);
			return;
		}
		for(int i=0; i<N; i++) {
			// 0부터 N-1번째 순서 중 i번째 순서가 아직 사용되지 않았다면
			if(!check[i]) {
				check[i] = true;
				sel[idx] = i; // idx번째 순서로 i번을 골라두고
				perm(idx + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();  // 2 ≤ N ≤ 10
			company = new Point(sc.nextInt(), sc.nextInt());
			home = new Point(sc.nextInt(), sc.nextInt());
			customers = new Point[N];
			for(int i=0; i<N; i++) {
				customers[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			check = new boolean[N];
			sel = new int[N];
			ans = 987654321;
			perm(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

}
