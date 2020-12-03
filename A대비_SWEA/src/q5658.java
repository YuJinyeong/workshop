import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

//5658. [모의 SW 역량테스트] 보물상자 비밀번호 
public class q5658 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N=0, K=0, S=0;
		String input;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			S = N/4; //한 변의 길이 => 회전 횟수 결정
			input = in.readLine();
			input = input.concat(input);
//			System.out.println(input + ": " + input.length());
			
			TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			});

			int s = 0, begin = 0;
			while(s++<S) {
				for(int i=begin, j=0; j<4; i+=S, ++j) {
					ts.add(input.substring(i, i+S));
				}
				++begin;
			}
			
			int k=0, ans = 0;
			for(String str : ts) {
				if(++k == K) {
					ans = Integer.parseInt(str, 16);
					break;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
