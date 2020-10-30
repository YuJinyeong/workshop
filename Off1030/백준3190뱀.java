import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����3190�� {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N; //������ ũ��
	static int K; //����� ũ��
	
	static int[][] map;
	static int L; //ȸ�� ����
	//ȸ�� ������ ������  map
	static Map<Integer, String> turnMap = new HashMap<>();
	//�̵� ���⿡ ���� ��ǥ ����
	// N = 0, E = 1, S = 2, W = 3
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		
		map = new int[N+1][N+1]; //�ε��� ����
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 1;
		}
		
		//ȸ�� ���� ó��
		L = Integer.parseInt(input.readLine());
		for(int l=0; l<L; l++) {
			tokens = new StringTokenizer(input.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			turnMap.put(t, tokens.nextToken());
		}
		
//		for(int[] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("ȸ������" + turnMap);
		
		Snake snake = new Snake();
		int time = 0;
		while(true) {
			boolean result = snake.move(turnMap.get(time));
			time++;
			if(!result) break;
		}
		System.out.println(time);
	}
	
	static class Point{
		int row, col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		//Queue�� ���ԵǾ� �ִ��� Ȯ���ϱ� ����
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
	
	static class Snake{
		//���� ������ ���ؼ� �湮�� ��������   Queue�� �־�����
		Queue<Point> body = new LinkedList<>();
		
		//���� ȸ���� ���� ���� ����
		int N = 0, E = 1, S = 2, W = 3;
		
		//�ʱ� ����
		int dir = E;
		//�ʱ� ��ġ, ���� ������
		Point head = new Point(1, 1);
		
		public Snake() {
			body.offer(head);
		}
		
		public boolean move(String d) {
			// ���� ���� ����
			//d�� null�̸� ������ �ʿ䰡 ����, null�� �ƴ϶�� ����
			if(d!=null) {
				if(d.equals("D")) {//�ð� �������� ȸ��
					 dir++;
					 if(dir==4) dir=N;
				}else if(d.equals("L")) {//�ݽð� �������� ȸ��
					dir--;
					if(dir==-1) dir=W;
				}
			}
			//���� ���� �Ϸ� --> ���� �Ӹ��� �̵��غ���.
			Point newHead = new Point(head.row + deltas[dir][0], head.col + deltas[dir][1]);
			//����Ǵ� ������ 2�� : ���ο� �Ӹ��� ������ ����ų�, ���� ������ �Ϻζ�� �׸�
			//������ ����� ���
			if(!isIn(newHead.row, newHead.col))
				return false;
			//�̹� ���Ե� ���
			else if(body.contains(newHead)) {
				return false;
			}
			//�׷��� �ʴٸ�.. ���ο� �Ӹ��� �������ְ� �̵�
			else {
				body.add(newHead);
				head = newHead;
				
				//�̵� ������ ����� �ִ��� ���ο� ���� ������ �������� ����
				//��� ���� --> �� ó�� ���� �༮ ����
				if(map[head.row][head.col]==0) {
					body.poll();
				}
				//�׷��� �ʴٸ� --> ���. �԰� Ŀ����.. --> ����
				else {
					map[head.row][head.col] = 0;
				}
				return true;
			}
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r>=1 && c>=1 && r<=N && c<=N;
	}
	
	static String src = "10\r\n" + 
			"5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"1 2\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
	
}
