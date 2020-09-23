import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N+1][3];
		int[][] D = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int c=0; c<3; c++) {
				D[i][c] = RGB[i][c] + Math.min(D[i-1][(c+1)%3], D[i-1][(c+2)%3]);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(min > D[N][i]) min = D[N][i];
		}
		
		System.out.println(min);
	}

}
