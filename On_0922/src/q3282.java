import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N, K, V[], C[], Res[][], max;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			V = new int[N+1];
			C = new int[N+1];
			Res = new int[N+1][K+1];
			max = 0;
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=K; j++) {
					if(V[i] > j)
						Res[i][j] = Res[i-1][j];
					else {
						Res[i][j] = Math.max(C[i]+Res[i-1][j-V[i]], Res[i-1][j]);
						if(Res[i][j] > max) max = Res[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
		
		
	}

}
