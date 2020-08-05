import java.util.ArrayList;
import java.util.Scanner;

public class 그래프의표현_인접리스트 {
	
// 첫 줄에는 정점의 갯수 N과 간선의 갯수 M이 주어진다.
// 그 다음 줄부터 M줄에 걸쳐서 두 정점의 번호가 주어진다.(간선배열)
// 그래프는 무향그래프이다.
// 입력되는 그래프를 인접리스트로 표현하시오.
	/*	
	7
	8
	0 1
	0 2	
	1 3
	1 4
	2 4
	3 5
	4 5
	5 6	
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList<Integer>[] adj = new ArrayList[N];
		
		for(int i=0; i<N;i++)
			adj[i]= new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		// 인쇄
		for(int i=0; i<N; i++)
			System.out.println(i + " : " + adj[i]);
	}

}
