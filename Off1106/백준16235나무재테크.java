
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����16235��������ũ {
	static int N, M, K; //N�� ��ǥũ��, M�� ���� ��, K�� �� ��
	
	static class Node{
		int val;	//�ܿ￡ �þ ��� ��
		int nutriment = 5;
		Node(int val){
			this.val = val;
		}
	}
	
	static Node[][] map;
	static class Tree implements Comparable<Tree>{
		int r, c, age;
		Tree(int r, int c, int age){
			this.r = r;
			this.c = c;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	//��� �������� ����� PQ
	static PriorityQueue<Tree> trees = new PriorityQueue<>();
	//���� ��Ƴ��� ������ ������ ó���Ǳ� ���� ����ϴ� ť
	static Queue<Tree> alive = new LinkedList<>();
	//���� ���� ������ ������ ó���Ǳ� ���� ����ϴ� ť
	static Queue<Tree> dead = new LinkedList<>();
	
	static void spring() {
		//PQ�� �ѹ��� ���鼭
		while(!trees.isEmpty()) {
			Tree tree = trees.poll();
			//�� �� �ִٸ�, ��� �Ծ� ġ��� ��� ť�� �־��ش�.
			if(tree.age <= map[tree.r][tree.c].nutriment) {
				map[tree.r][tree.c].nutriment -= tree.age;
				tree.age += 1;
				alive.add(tree);
			}
			//�� �� ���ٸ�, ���� �� ť�� �־��ش�.
			else
				dead.add(tree);
		}
	}
	
	static void summer() {
		//���� �� ť�� �ѹ��� ���鼭
		//�ش� ��ġ�� �״� ���� ����/2��ŭ�� ����� �����ش�.
		while(!dead.isEmpty()) {
			Tree tree = dead.poll();
			map[tree.r][tree.c].nutriment += tree.age/2;
		}
	}
	
	static void autumn() {
		//�� �� ť�� ���鼭
		while(!alive.isEmpty()) {
			Tree tree = alive.poll();
			//���̰� 5�� ����̸� �ȹ濡 ����1�� ������ �����ؼ� ���� ��ť�� �־��ش�.
			if(tree.age%5 == 0) {
				//�ȹ濡 �ڽĳ��� ����
				for(int d=0; d<8; d++) {
					int nr = tree.r + dr[d];
					int nc = tree.c + dc[d];
					if(nr>=1 & nc>=1 && nr<=N && nc<=N)
						trees.add(new Tree(nr, nc, 1));
				}
			}
			//�ڽ��� �״�� ����PQ�� �־��ش�.
			trees.add(tree);
		}
	}
	
	static void winter() {
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) 
				map[i][j].nutriment += map[i][j].val;
		}
	}
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Node[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j] = new Node(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			trees.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i = 0 ; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		
		System.out.println(trees.size());
		
		
	}
}
