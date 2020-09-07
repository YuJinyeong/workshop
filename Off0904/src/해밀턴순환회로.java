import java.util.Scanner;

public class 해밀턴순환회로 {
	static int N;
	static int[][] adj;
	static boolean[] visited;
	static int ans = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N];
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	static void dfs(int current, int cost, int depth) {
		if (depth == N) {
			// 집으로 가는 길이 없다면 실패
			if (adj[current][0] == 0)
				return;
			cost += adj[current][0];
			ans = Math.min(ans, cost);
			return;
		}
		// 모든 후보들에 대해서
		for (int i = 1; i < N; i++) {
			// 방문 안한 곳이 있다면
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, cost + adj[current][i], depth + 1);
				visited[i] = false;
			}

		}
	}
}
