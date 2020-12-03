import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1812. 수정이의 타일 자르기  
public class q1812 {
	static class Rectangle implements Comparable<Rectangle>{
		int max, min;
		public Rectangle(int width, int height) {
			min = Math.min(width, height);
			max = Math.max(width, height);
		}
		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
	}
	
	static int N, M, size[], cnt;
	static PriorityQueue<Rectangle> qu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			}
			cut();
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

	private static void cut() {
		// 만들고자 하는 크기가 큰 타일부터 처리
		Arrays.sort(size);
		qu = new PriorityQueue<>();
		qu.offer(new Rectangle(M, M)); //타일 1장 사고 시작
		++cnt; //타일 갯수 증가
		
		for(int i=N-1; i>=0; i--) {
			//shift연산자로 *2..
			go(1<<size[i]); // 1	1<<1 : 10(2), 1<<2 : 100(4)
		}
		
	}

	private static void go(int size) {
		// 자투리 타일 중에 min변이 크기가 최대인 놈 꺼내서 비교
		Rectangle r = qu.poll();
		
		// 원하는 크기의 타일을 만들 수 있다면	만들고 잘라낸 2개의 자투리 타일을 다시 보관
		if(r.min >= size) {
			qu.offer(new Rectangle(r.min-size, size));
			qu.offer(new Rectangle(r.min, r.max-size));
		}else {
		// 원하는 크기의 타일을 만들 수 없다면	새로 타일을 구매해서 잘라내고(이때, 구매한 타일 개수 카운트 증가)
		//							잘라낸 2개의 타일을 다시 보관
		//							꺼내고 사용하지 않은 타일 다시 보관
			cnt++;
			qu.offer(new Rectangle(M-size, size));
			qu.offer(new Rectangle(M-size, M));
			qu.offer(r);
		}
	}
}
