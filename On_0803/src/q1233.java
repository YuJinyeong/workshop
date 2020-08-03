import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.1233 사칙연산 유효성 검사
public class q1233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char bst[] = new char[N + 1];
			int ans = 1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				char c = st.nextToken().charAt(0);
				if (ans == 1) {
					if (c >= '0' && c <= '9') {
						if (st.hasMoreTokens()) {
							ans = 0;
						}
						bst[i] = c;
					} else {
						bst[i] = c;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		System.exit(0);
	}

}
