import java.util.Scanner;

public class 최적경로2 {
	static class Point {
		int x, y;

		Point(int x, int y) {
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
	static int N, ans;

	// 마비막 방문고객 위치로부터, idx번째 고객까지의 거리를 더해서 누적거리에 더해나간다.
	// idx번째 고객에 방문. 지금까지 누적거리 유지. 마지막 방문했던 위치.
	static void visit(int idx, Point last, int dist) {
		if(ans <= dist)
			return;
		// 모든 고객을 다 방문함
		if(idx == N) {
			dist += (Math.abs(last.x - home.x) + Math.abs(last.y - home.y));
			ans = Math.min(ans, dist);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				int tmp = Math.abs(last.x - customers[i].x) + Math.abs(last.y - customers[i].y);
				visit(idx + 1, customers[i], dist + tmp);
				check[i] = false;
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 2 ≤ N ≤ 10
			company = new Point(sc.nextInt(), sc.nextInt()); // 처음 두개는 회사의 좌표
			home = new Point(sc.nextInt(), sc.nextInt()); // 그 다음 두개는 집의 좌표
			customers = new Point[N];
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			check = new boolean[N];
			ans = 987654321;
			visit(0, company, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
