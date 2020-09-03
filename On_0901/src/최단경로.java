import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// Q.1753 최단경로
public class 최단경로 {
	static class Edge {
		int v, weight;

		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()) - 1; // 시작 정점(번호를 1번부터 셈)
		
		// 인접 리스트를 준비
		List<Edge>[] adj = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 간선의 정보를 입력
		for(int i=0; i<E; i++) {
//			int start = sc.nextInt() - 1;
//			int dest = sc.nextInt() - 1;
//			int weight = sc.nextInt();
//			adj[start].add(new Edge(dest, weight));
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())-1].add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		// dist 배열 준비
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		dist[K] = 0;
		
		for(int i=0; i<V; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			// check되지 않았으면서 dist값이 제일 작은 정점의 번호를 찾으시오.
			for(int j=0; j<V; j++) {
				if(!check[j] && min > dist[j]) {
					min = dist[j];
					index = j;
				}
			}
			// 못 찾았으면 땡
			if(index == -1)
				break;
			
			// 찾은 정점으로부터 갈 수 있는 경로가 이미 알고 있는 dist보다 작다면 갱신
			// index가 가지고 있는 모든 간선을 검사한다
			for(Edge next : adj[index]) {
				// check되지 않았으면서 그놈까지의 거리가 나까지의 거리 + 나로부터 그 놈까지 거리 보다 작다면 갱신
				if(!check[next.v] && dist[next.v] > dist[index] + next.weight)
					dist[next.v] = dist[index] + next.weight;
			}

			// 할 일 다했으면 체크된 놈으로 분류
			check[index] = true;
		}
		for(int i=0; i<V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
