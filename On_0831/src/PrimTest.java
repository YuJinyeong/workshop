import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//간선이 엄청나게 꽉차게 많아도
//프림이 크루스칼보다 딱히 유리하지 않다.
//피보나치힙을 쓴다면 이론 상 그러하지만 실제 딱히 그렇지도 않다.
//피보나치힙 동작 자체의 오버헤드가 크기 때문에 
//그리고 실제 활용되는 그래프들은 딱히 간선이 많은 경우도 없다.
//그리고 그래프라는 자료구조가 다른 어떤 자료구조보다도 굉장히 복잡도가 높고
//데이터의 양이 매우 크기 떄문에
//실제 연산에서는 병렬처리 분산처리가 요구되는 경우가 많고
//병렬처리 면에서 크루스칼이 구조적으로 프림보다 상당히 유리하다.
//그래서 크루스칼을 병렬처리에 맞게 만들어낸 알고리즘 이름은 보르프카 알고리즘이고
//이녀석이 주로 실제 활용됨

//동작원리
//확보된 정점 집합을 기억하고 있어야 함
//확보된 정점집합에서 출발하는 모든 간선 중에 가장 비용이 작은 녀석을 고른다.

//프림 알고리즘이용

//확보된 정점들 중에서 뻗어나가는 간선 중 젤 비용이 짧으면서. 
//목적지가 확보되지 않은 곳인 간선을 찾는다.
//그 간선이 연결되는 목적지를 확보된 정점으로 넣는다.
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
*/

public class PrimTest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = Integer.parseInt(br.readLine().trim());
		int[][] input = new int[cnt][cnt];
		// 여기에 true로 써있는 곳을 확보된 정점으로 아닌 것을 비확보정점으로 구분하자.
		boolean[] visited = new boolean[cnt];
		// 해당 정점까지. 알려진 최단거리.
		int[] minEdge = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cnt; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			// 처음 알려진 거리들은 모두 무한대.
			minEdge[i] = Integer.MAX_VALUE;
		} // i노드에서 j노드까지의 비용을 모두 배열에 저장

		int minVertex, min, result = 0;
		// 출발정점은 알려진 거리를 젤 작은 값으로 세팅.
		minEdge[0] = 0;

		for (int c = 0; c < cnt; c++) {
			min = Integer.MAX_VALUE;
			minVertex = 0;

			for (int i = 0; i < cnt; ++i) {
				// 확보되지 않았으면서. 알려진 거리가 젤 작은 정점을 찾는다.
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			result += min;
			// 확보된 정점으로 셋팅하고.
			visited[minVertex] = true;

			// 새로 확보된 정점에서 출발하는 간선들의 비용들을 보면서
			// 알려진 거리를 갱신한다.
			for (int j = 0; j < cnt; j++) {
				// 목적지가 확보되지않은 간선중에
				// 경로가 존재하면서
				// 알려진 거리보다 더 짧다면
				if (!visited[j] && input[minVertex][j] != 0 && input[minVertex][j] < minEdge[j]) {
					// 갱신ㅋ
					minEdge[j] = input[minVertex][j];
				}
			}
		}
		System.out.println(result);
	}
}
