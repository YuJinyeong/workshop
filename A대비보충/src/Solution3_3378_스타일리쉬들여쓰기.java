import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3_3378_스타일리쉬들여쓰기 {
	static int p, q;
	static char[][] master, own;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			master = new char[p][];
			own = new char[q][];
			result = new int[q];
			
			Arrays.fill(result, -2);
			
			for (int i = 0; i < p; i++) {
				master[i] = in.readLine().toCharArray();
			}

			for (int i = 0; i < q; i++) {
				own[i] = in.readLine().toCharArray();
			}

			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (getRCS(r, c, s)) {
							setIndent(r, c, s);
						}
					}
				}
			}

			sb = new StringBuilder("#" + tc + " ");
			for(int rs : result)
				sb.append(rs).append(" ");

			System.out.println(sb.toString());
		}
	}

	private static void setIndent(int r, int c, int s) {
		int countR = 0, countC = 0, countS = 0;

		for (int i = 0; i < q; i++) {
			int indent = r * countR + c * countC + s * countS;
			
			if(result[i] == -2) {
				result[i] = indent;
			}else {
				if(result[i] != indent)
					result[i] = -1;
			}
			
			for (char ch : own[i]) {
				switch (ch) {
				case '(': countR++; break;
				case ')': countR--; break;
				case '{': countC++; break;
				case '}': countC--; break;
				case '[': countS++; break;
				case ']': countS--; break;
				}
			}
		}
	}

	private static boolean getRCS(int r, int c, int s) {
		int countR = 0, countC = 0, countS = 0;

		for (int i = 0; i < p; i++) {
			int cnt = 0;

			for (char ch : master[i]) {
				if (ch == '.')
					cnt++;
				else
					break;
			}

			int indent = r * countR + c * countC + s * countS;
			if (indent != cnt)
				return false;

			for (char ch : master[i]) {
				switch (ch) {
				case '(': countR++; break;
				case ')': countR--; break;
				case '{': countC++; break;
				case '}': countC--; break;
				case '[': countS++; break;
				case ']': countS--; break;
				}
			}
		}
		return true;
	}
}
