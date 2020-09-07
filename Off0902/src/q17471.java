import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Q.17471 게리맨더링
public class q17471 {
	static int[] map;
	static boolean[][] connect;
	static boolean[] check;
	static int N, ans, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		map = new int[N];
		connect = new boolean[N][N];
		check = new boolean[N];

		st = new StringTokenizer(in.readLine(), " ");
		sum = 0;
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			sum += map[i];
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			st.nextToken();// 개수
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken()) - 1;
				if (i == n)
					continue;
				connect[i][n] = true;
				connect[n][i] = true;
			}
		}

		ans = Integer.MAX_VALUE;
		powerSet(0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void powerSet(int idx) {
		if (idx == N) {
			// 모든 선거구가 팀배정이 완료됨
			if (check()) {
				int sumA = 0;
				int sumB = 0;
				// 각 선거구들을 검사해가면서
				for (int i = 0; i < N; i++) {
					// 선택된 애는 A팀. 아닌 애는 B팀
					if (check[i])
						sumA += map[i];
					else
						sumB += map[i];
				}
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			return;
		}

		check[idx] = true;
		powerSet(idx + 1);
		check[idx] = false;
		powerSet(idx + 1);
	}

	private static void comb(int idx, int idx_s, int s1, int s2) {
		if (idx == N) {
			if (s1 != 0 && s2 != 0 && s1 + s2 == sum && check()) {
				ans = Math.min(ans, Math.abs(s1 - s2));
//				System.out.println(s1 + ", " + s2 + " => " + sum);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (connect[idx][i] && !check[i]) {
				check[i] = true;
				comb(idx + 1, idx_s + 1, s1 + map[i], s2);
				check[i] = false;
				comb(idx + 1, idx_s, s1, s2 + map[i]);
			}
		}
	}

	static boolean check() {
		boolean[] visited = new boolean[N];
		// A팀 중 하나를 골라서 출발지 삼아서 인접한 선거구를 방문해가며 visited에 true로 변경
		// B팀 중 하나를 골라서 출발지 삼아서 인접한 선거구를 방문해가며 visited에 true로 변경

		// A팀 출발지를 고르자.
		int teamA = -1;
		for (int i = 0; i < N; i++) {
			if (check[i]) {
				teamA = i;
				break;
			}
		}
		// teamA에는 A팀의 첫번째 선거구가 들어가있겠당..ㅎ
		int teamB = -1;
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				teamB = i;
				break;
			}
		}
		// teamB에는 B팀의 첫번째 선거구가 들어가있겠당..ㅎ

		// teamA나 teamB가 선거구를 찾지 못하고 -1로 남아있다는건 해당 팀에 선거구가 없다는 것.
		if (teamA == -1 || teamB == -1)
			return false;

		// 각 팀의 선거구를 teamA와 teamB를 출발지 삼아서 탐색을 시작하는데, 방법은 dfs혹은 bfs.
		Queue<Integer> queue = new LinkedList<>();

		// teamA탐색.
		// teamA의 출발주자를 큐에 넣고, visited에 트루로 체크하고 while돌자
		queue.add(teamA);
		visited[teamA] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			// 모든 선거구들 중에서 나와 같은 팀이면서. 나와 연결이 있으면서. 방문하지 않았다면 큐에 삽입
			for (int i = 0; i < N; i++) {
				// 같은 팀이 아니면 재껴 우리팀은 sel[i]가 true야
				if (!check[i])
					continue;
				// 방문했던 친구도 재껴
				if (visited[i])
					continue;
				// 경로가 없어도 재껴
				if (!connect[node][i])
					continue;
				visited[i] = true;
				queue.add(i);
			}
		}

		// teamB의 출발주자를 큐에 넣고, visited에 트루 체크하고 while돌자
		queue.add(teamB);
		visited[teamB] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			// 모든 선거구들 중에서 나와 같은 팀이면서. 나와 연결이 있으면서. 방문하지 않았다면 큐에 삽입
			for (int i = 0; i < N; i++) {
				// 같은 팀이 아니면 재껴 우리팀은 sel[i]가 false야
				if (check[i])
					continue;
				// 방문했던 친구도 재껴
				if (visited[i])
					continue;
				// 경로가 없어도 재껴
				if (!connect[node][i])
					continue;
				visited[i] = true;
				queue.add(i);
			}
		}

		// visited의 1부터 N까지 중에 false가 발견되면 글러먹었다. return false
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				return false;
		}
		// return false를 당한 적이 없다... return true;
		return true;
	}
}
