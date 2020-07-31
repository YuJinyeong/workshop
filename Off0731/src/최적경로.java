import java.util.Scanner;

public class 최적경로 {

	private static int[] locations_x;
	private static int[] locations_y;
	private static int[] Route;
	private static boolean[] check;
	private static int N;
	private static int off_x, off_y, home_x, home_y;
	private static int MIN = 9999999;

	public static void perm(int cnt) {
		if (cnt == N) {
			calc(Route);
			return;
		}

		for (int i = 1; i <= N; i++) {
			// 중복 확인
			if (check[i])
				continue;

			Route[cnt] = i;
			check[i] = true;

			perm(cnt + 1);

			check[i] = false;
		}

	}

	private static void calc(int[] route2) {
		int dis_x = 0, dis_y = 0, tot = 0, i = 1;

		// 회사부터 거리
		dis_x = Math.abs(off_x - locations_x[route2[0]]);
		dis_y = Math.abs(off_y - locations_y[route2[0]]);
		tot += dis_x + dis_y;

		for (i = 1; i < route2.length - 1; i++) {
			dis_x = Math.abs(locations_x[route2[i - 1]] - locations_x[route2[i]]);
			dis_y = Math.abs(locations_y[route2[i - 1]] - locations_y[route2[i]]);
			tot += dis_x + dis_y;
		}

		// 집까지 거리
		dis_x = Math.abs(locations_x[route2[i-1]] - home_x);
		dis_y = Math.abs(locations_y[route2[i-1]] - home_y);
		tot += dis_x + dis_y;

		if (tot < MIN)
			MIN = tot;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			MIN = 9999999;
			int N = sc.nextInt();
			locations_x = new int[N];
			locations_y = new int[N];
			check = new boolean[N];
			Route = new int[N];

			off_x = sc.nextInt();
			off_y = sc.nextInt();
			home_x = sc.nextInt();
			home_y = sc.nextInt();

			for (int i = 0; i < N; i++) {
				locations_x[i] = sc.nextInt();
				locations_y[i] = sc.nextInt();
			}

			perm(0);

			System.out.println("#" + tc + " " + MIN);
		}
	}

}
