import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2096 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][3];
		int scr1[][] = new int[N][3];
		int scr2[][] = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<3; j++) {
			scr1[0][j] = map[0][j];
			scr2[0][j] = map[0][j];
		}
		
		int[] dc = {-1, 0, 1};
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<3; j++) {
				scr1[i+1][j] = Math.max(scr1[i+1][j], scr1[i][j]+map[i+1][j]);
				scr2[i+1][j] = scr2[i+1][j]==0?scr2[i][j]+map[i+1][j]:Math.min(scr2[i+1][j], scr2[i][j]+map[i+1][j]);
				if(j+1 < 3) {
					scr1[i+1][j+1] = Math.max(scr1[i+1][j+1], scr1[i][j]+map[i+1][j+1]);
					scr2[i+1][j+1] = scr2[i+1][j+1]==0?scr2[i][j]+map[i+1][j+1]:Math.min(scr2[i+1][j+1], scr2[i][j]+map[i+1][j+1]);
				}
				if(j > 0) {
					scr1[i+1][j-1] = Math.max(scr1[i+1][j-1], scr1[i][j]+map[i+1][j-1]);
					scr2[i+1][j-1] = scr2[i+1][j-1]==0?scr2[i][j]+map[i+1][j-1]:Math.min(scr2[i+1][j-1], scr2[i][j]+map[i+1][j-1]);
				}
			}
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int j=0; j<3; j++) {
			if(max < scr1[N-1][j]) max = scr1[N-1][j];
			if(min > scr2[N-1][j]) min = scr2[N-1][j];
		}
		System.out.println(max + " " + min);
	}
}
