import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, arr[], len[];
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			len = new int[N + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && len[i] < len[j] + 1)
						len[i] = len[j] + 1;
				}
				if (max < len[i])
					max = len[i];
			}
			System.out.println("#" + tc + " " + max);
			
			// 출력
			int[] LIS = new int[max];
			for (int i = N; i > 0; i--) {
				if (max < 0)
					break;
				if (len[i] == max) {
					LIS[max - 1] = arr[i];
					max--;
				}
			}
			System.out.println(Arrays.toString(LIS));
		}
	}
}
