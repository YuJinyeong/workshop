import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3289 {

	static int[] parent;
	static int[] rank;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			rank = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			int n1, n2, n3;
			sb.append("#" + tc + " ");
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				n1 = Integer.parseInt(st.nextToken());
				n2 = Integer.parseInt(st.nextToken());
				n3 = Integer.parseInt(st.nextToken());
				if (n1 == 0) {
					union(n2, n3);
				} else if (n1 == 1) {
					if (find(n2) == find(n3))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		int p = find(parent[x]);
		parent[x] = find(parent[x]);
		return p;
	}

	static void union(int x, int y) {
		int px = find(x); // x의 대표자를 찾음
		int py = find(y); // y의 대표자를 찾음

		if (rank[px] > rank[py])
			parent[py] = px;
		else if (rank[px] < rank[py])
			parent[px] = py;
		else {
			parent[px] = py;
			rank[py]++;
		}
	}
}
