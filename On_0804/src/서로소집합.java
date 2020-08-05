import java.util.Arrays;

public class 서로소집합 {
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		// 원소는 7개가 있다고 하자. 첫번쨰 원소는 0이고 일곱번째 원소는 6이다.
		parent = new int[7];
		rank = new int[7]; // 초기 rank는 다 0. rank에는 트리의 depth가 들어있음
		// parent[0]는 원소 0의 부모의 번호가 저장될 곳

		// 처음엔 모두가 각자가 혼자로서의 집합으로 스스로가 대표자인 상황,
		for (int i = 0; i < 7; i++) 
			parent[i] = i;
		
		union(1, 2);
		System.out.println(Arrays.toString(parent));
		union(2, 3);
		System.out.println(Arrays.toString(parent));
		union(3, 4);
		System.out.println(Arrays.toString(parent));
		union(4, 5);
		System.out.println(Arrays.toString(parent));
		
		for(int i=0; i<7; i++)
			System.out.println(find(i));
	}

	// 원소 x에 대해서 대표자를 찾아주는 연산
	static int find(int x) {
//		내가 x라면 return x;
		if (x == parent[x])
			return x;

		// 아래 반복은 몇번 해야될지 모름.....
		parent[x] = find(parent[x]);
		return find(parent[x]);
//		내 부모는 parent[x] return parent[x];
//		내 부모의 부모는 parent[parent[x]] return parent[parent[x]];
	}
	
	static void union(int x, int y) {
		int px = find(x); // x의 대표자를 찾음
		int py = find(y); // y의 대표자를 찾음
		
		if(rank[px] > rank[py])
			parent[px] = px;
		else if(rank[px] < rank[py])
			parent[px] = py;
		else {
			parent[px] = py;
			rank[py]++;
		}
	}

}
