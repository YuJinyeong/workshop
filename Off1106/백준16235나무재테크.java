
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

public class 백준16235나무재테크 {
	static int N, M, K; //N은 좌표크기, M은 나무 수, K는 몇 년
	
	static class Node{
		int val;	//겨울에 늘어날 양분 양
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
	
	//모든 나무들이 대기할 PQ
	static PriorityQueue<Tree> trees = new PriorityQueue<>();
	//봄에 살아남은 나무가 가을에 처리되기 위해 대기하는 큐
	static Queue<Tree> alive = new LinkedList<>();
	//봄에 죽은 나무가 여름에 처리되기 위해 대기하는 큐
	static Queue<Tree> dead = new LinkedList<>();
	
	static void spring() {
		//PQ를 한바퀴 돌면서
		while(!trees.isEmpty()) {
			Tree tree = trees.poll();
			//살 수 있다면, 양분 먹어 치우고 산놈 큐에 넣어준다.
			if(tree.age <= map[tree.r][tree.c].nutriment) {
				map[tree.r][tree.c].nutriment -= tree.age;
				tree.age += 1;
				alive.add(tree);
			}
			//살 수 없다면, 죽은 놈 큐에 넣어준다.
			else
				dead.add(tree);
		}
	}
	
	static void summer() {
		//죽은 놈 큐를 한바퀴 돌면서
		//해당 위치에 죽는 나무 나이/2만큼의 양분을 더해준다.
		while(!dead.isEmpty()) {
			Tree tree = dead.poll();
			map[tree.r][tree.c].nutriment += tree.age/2;
		}
	}
	
	static void autumn() {
		//산 놈 큐를 돌면서
		while(!alive.isEmpty()) {
			Tree tree = alive.poll();
			//나이가 5의 배수이면 팔방에 나이1인 나무를 생성해서 나무 피큐에 넣어준다.
			if(tree.age%5 == 0) {
				//팔방에 자식나무 생성
				for(int d=0; d<8; d++) {
					int nr = tree.r + dr[d];
					int nc = tree.c + dc[d];
					if(nr>=1 & nc>=1 && nr<=N && nc<=N)
						trees.add(new Tree(nr, nc, 1));
				}
			}
			//자신은 그대로 나무PQ에 넣어준다.
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
