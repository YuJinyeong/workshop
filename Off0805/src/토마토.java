import java.util.Scanner;

//백준 Q.7576 토마토
public class 토마토 {
	static int Q;
	static int W;
	static int[][] direct = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q = sc.nextInt();
		W = sc.nextInt();
		int count = 0;
		int count1 = 0;
		boolean check = false;
		int[][] map = new int[W][Q];
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < Q; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		loop: for (int i = 0; i < W; i++) {
			for (int j = 0; j < Q; j++) {
				int con = 0;
				if (map[i][j] == 1) {
					break loop;
				}
				if (map[i][j] == 0 || map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int dx = i + direct[k][0];
						int dy = j + direct[k][1];
						if (dx >= 0 && dx < W && dy >= 0 && dy < Q && map[dx][dy] == 0) {
							con++;
						}

					}
				}
				if (map[i][j] != -1 && con == 0) {
					count1 = -1;
					break loop;
				}
			}
		}
		int P = 2;
		while (check == false) {
			boolean cho[][] = new boolean[W][Q];
			if (count1 == -1) {
				System.out.println(count1);
				break;
			}
			boolean not = true;
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < Q; j++) {
					if (map[i][j] == 0) {
						not = false;
					}
					if (map[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							int dx = i + direct[k][0];
							int dy = j + direct[k][1];
							if (dx >= 0 && dx < W && dy >= 0 && dy < Q && map[dx][dy] != -1 && cho[i][j] == false) {
								if (map[dx][dy] != 1) {
									map[dx][dy] = 1;
									cho[dx][dy] = true;
								}
							}
						}
					}
				}
			}
			if (not == true) {
				break;
			}
			count++;
		}
		if (count1 == -1) {
		} else {
			System.out.println(count);
		}
	}

}
