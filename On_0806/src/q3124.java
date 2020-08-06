import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3124 {
	static int V, E;
	static int[] parent;
	static edgeSet[] es;

	static class edgeSet implements Comparable<edgeSet> {
		int u, v, w;

		edgeSet(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(edgeSet o) {
			return this.w - o.w;
		}
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		parent[py] = px;
		return true;
	}

	private static void make() {
		for (int i = 1; i < V+1; i++)
			parent[i] = i;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			es = new edgeSet[E];


			int u = 0, v = 0, w = 0;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				es[e] = new edgeSet(u, v, w);
			}

			Arrays.sort(es);
			make();
			long Answer = 0;
			int cnt = 0;
			for (edgeSet edge : es) {
				if (union(edge.u, edge.v)) {
					cnt++;
					Answer += edge.w;
					if (cnt == V - 1)
						break;
				}
			}
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
