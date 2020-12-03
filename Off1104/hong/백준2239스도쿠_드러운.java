package hong;
import java.util.Scanner;

//0부터 80번까지를... 0부터 8이 1줄 9부터 17이 2줄.. 이런식으로 인덱스를 관리합니다.
public class 백준2239스도쿠_드러운 {
	static StringBuilder sb = new StringBuilder();
//	static PriorityQueue<String> pq = new PriorityQueue<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			sb.append(sc.next());
		dfs(sb.toString().toCharArray());
		for(int i = 0; i < 81; i += 9) {
			System.out.println(ans.substring(i, i+9));
		}
	}
	static String ans = null;
	static void dfs(char[] s) {
		//이미 답을 찾았으면 그만.
		if(ans != null)
			return;
		//처음으로 0이 아닌 인덱스를 찾습니다.
		int idx = -1;
		for(int i = 0; i < 81; i++) {
			if(s[i] == '0') {
				idx = i;
				break;
			}
		}
		//0인곳이 안남았으면 정답입니다.
		if(idx == -1) {
			ans = new String(s);
			return;
		}
		//처음 0이 시작되는 위치의 행이 몇번째 행인지
		int rowStart = idx / 9;
		//몇번째 열인지	
		int colStart = idx % 9;
		//그 행열 위치의 정사각박스의 출발점이 어딘지.
		int boxStart = rowStart / 3 * 3 * 9+ colStart / 3 * 3;
		//작은수부터 넣어봅니다 1~9
		for(int i = 1; i < 10; i++) {
			//가로 세로 박스를 검사해서
			if(check(s, (char)(i + 48), rowStart, colStart, boxStart)) {
				//원래값 챙기고
				char tmp = s[idx];
				//찾은 값 넣고
				s[idx] = (char) (i + 48);
				//다음 스탭
				dfs(s);
				//원복
				s[idx] = tmp;
			}
		}
	}
	static boolean check(char[] s,char val, int rS, int cS, int bS) {
		//9개에 대해ㅓㅅ
		for(int i = 0; i < 9; i++) {
			//내가 있는 행에 같은 값 있는지
			if(s[rS*9+i] == val) 
				return false;
			//열에 같은 값 있는지
			if(s[cS+9*i] == val)
				return false;
		}
		//박스 검사.
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(s[bS + 9*i + j] == val)
					return false;
			}
		}
		return true;
	}
}