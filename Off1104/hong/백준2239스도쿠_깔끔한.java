package hong;
import java.util.Scanner;

public class 백준2239스도쿠_깔끔한 {
	static char[][] map = new char[9][9];
	static boolean isFinished;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			map[i] = sc.next().toCharArray();
		dfs(0, 0);
		System.out.println(ans);
	}
	
	static String ans = "";
	static void dfs(int r, int c) {
		if(isFinished)	return;
		
		if(r == 9 && c == 0) {
			isFinished = true;
			for(int i = 0; i < 9; i++) {
				ans += new String(map[i]) + "\n";
			}
			return;
		}
		
		if( map[r][c] == '0' ) {
			//1부터 9까지 숫자 중에서, 행.열.박스에 들어있지 않은 숫자들은 넣고 다음으로 가봐.
			for(int num = 1; num < 10; num++) {
				if( check(r, c, (char)(num+48))) {
					char tmp = map[r][c];
					map[r][c] = (char)(num+48);
					//맨 끝 칸이면 다음줄로 이동	
					if(c == 8) 
						dfs(r+1, 0);
					//아니면 그냥 다음칸으로 이동
					else
						dfs(r, c+1);
					map[r][c] = tmp;
				}
			}
		}
		
		//현재 자리가 0이 아닌 경우는 다음 칸으로 이동
		else {
			//맨 끝 칸이면 다음줄로 이동	
			if(c == 8) 
				dfs(r+1, 0);
			//아니면 그냥 다음칸으로 이동
			else
				dfs(r, c+1);
		}
	}
	
	//r,c자리에 val숫자가 들어가도 되는지 검사.
	static boolean check(int r, int c, char val) {
		//행이랑 열에 같은 값이 있는지 검사
		for(int i = 0; i < 9; i++) {
			if(map[r][i] == val)
				return false;
			if(map[i][c] == val)
				return false;
		}
		//박스검사
		int bSr = r / 3 * 3;
		int bSc = c / 3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[bSr + i][bSc + j] == val)
					return false;
			}
		}
		return true;
	}
}