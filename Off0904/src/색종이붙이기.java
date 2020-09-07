import java.util.Scanner;

public class 색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++)
				map[i][j] = sc.nextInt();
		}
		dfs(0);
		System.out.println(ans == 987654321 ? -1 : ans);
	}
	static int ans = 987654321;
	static void dfs(int cnt) {
		//왼쪽위부터 처음으로 1인 곳 그러니까 색종이가 붙을 수 있는 시작점을 찾는다.
		int sR = -1;
		int sC = -1;
		out:for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 1) {
					sR = i; sC = j;
					break out;
				}
			}
		}
		
		//붙일곳이 존재하지 않는다면 더이상 붙일 필요가 없으므로 종료.
		if( sR == -1 && sC == -1) {
			ans = Math.min(ans, cnt	);
			return;
		}
		
		//찾은 위치에 붙일 수 있는 가장 큰 색종이의 크기를 구한다.
		int max = 5;
		while( max > 0 ) {
			boolean isOk = true;
			out : for(int i = 0; i < max; i++) {
				for(int j = 0; j < max; j++) {
					//시작위치에서 색종이크기 만큼 넘어 갔을때 밖으로 나가거나, 색종이를 붙일 수 없다면 망.
					if( sR + i >= 10 || sC + j >= 10 || map[sR + i][sC + j] == 0) {
						isOk = false;
						break out;
					}
				}
			}
			//찾은게 성공이면 그만두고
			if(isOk)
				break;
			//아니면 max를 하나 줄이고 다시
			max--;
		}
		
		//크기1부터 구한 가장큰 크기의 색종이를 붙여본다.
		for(int i = 1; i <= max; i++) {
			//해당 크기의 색종이가 없으면 패스
			if(paper[i] == 0)
				continue;
			for(int r = sR; r < sR+i; r++) {
				for(int c = sC; c < sC+i; c++) {
					map[r][c] = 0;
				}
			}
			paper[i]--;
			dfs(cnt + 1);
			paper[i]++;
			for(int r = sR; r < sR+i; r++) {
				for(int c = sC; c < sC+i; c++) {
					map[r][c] = 1;
				}
			}
		}
		//색종이를 붙이면 다음 색종이 붙이러 간다. 
		//그리고 다시 색종이를 뗀다.
	}
}
