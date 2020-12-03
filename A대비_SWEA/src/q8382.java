import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//8382. 방향 전환
public class q8382 {
	static int[][][] dirs = {{{1, 0}, {-1, 0}}, {{0, 1}, {0, -1}}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int x1=0, y1=0, x2=0, y2=0;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int moveR = Math.abs(x2 - x1);
			int moveC = Math.abs(y2 - y1);
			
			while(Math.abs(moveR - moveC) > 1) {
				if(moveR < moveC) moveR += 2;
				else moveC += 2;
			}
			
			System.out.println("#" + tc + " " + (moveR + moveC));
		}
	}
}
