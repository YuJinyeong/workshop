import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퍼펙트셔플 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder stb;
		for (int tc = 1; tc <= test_case; tc++) {
			stb = new StringBuilder();
			stb.append("#" + tc + " ");
			int len = Integer.parseInt(br.readLine());
			int pl = (len + 1) / 2;
			String[] arr = br.readLine().split(" ");
			for (int i = 0; i < len / 2; i++)
				stb.append(arr[i] + " " + arr[pl + i] + " ");
			if (len % 2 == 1)
				stb.append(arr[pl - 1]);
			System.out.println(stb);
		}
	}

}
