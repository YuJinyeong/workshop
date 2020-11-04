package hong;

import java.util.Scanner;

public class SWEA4013특이한자석_선 {
	public static int answer, K, wheel[], nextdir[], wheelInfo[][];
	public static int[] answers = { 1, 2, 4, 8 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tests = sc.nextInt();

		for (int test = 1; test <= Tests; test++) {
			answer = 0;
			wheel = new int[4];
			wheelInfo = new int[4][8];
			K = sc.nextInt();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					wheelInfo[i][j] = sc.nextInt();
				}
			}

			for (int round = 1; round <= K; round++) {

				nextdir = new int[4];
				int selectedWheel = sc.nextInt() - 1;
				int dir = sc.nextInt(); // 1은 시계
				int nextdirect = dir == 1 ? -1 : 1;
				int nextdirectL = dir == 1 ? -1 : 1;
				nextdir[selectedWheel] = dir;

				// 오른쪽
				for (int i = 0; i < 3; i++) {

					if (selectedWheel + 1 + i > 3) {
						break;
					}

					if (wheelInfo[selectedWheel + i][(wheel[selectedWheel + i] + 2)
							% 8] != wheelInfo[selectedWheel + 1 + i][(wheel[selectedWheel + 1 + i] + 6) % 8]) {

						nextdir[i + selectedWheel + 1] = nextdirect;
						nextdirect = nextdirect == 1 ? -1 : 1;
					} else {
						break;
					}

				}
				// 왼쪽
				for (int i = 0; i < 3; i++) {
					if (selectedWheel - 1 - i < 0) {
						break;
					}
					if (wheelInfo[selectedWheel - i][(wheel[selectedWheel - i] + 6)
							% 8] != wheelInfo[selectedWheel - 1 - i][(wheel[selectedWheel - 1 - i] + 2) % 8]) {
						nextdir[selectedWheel - i - 1] = nextdirectL;
						nextdirectL = nextdirectL == 1 ? -1 : 1;
					} else {
						break;
					}
				}

				for (int i = 0; i < 4; i++) {
					if (nextdir[i] != 0) {
						if (nextdir[i] == 1) {

							wheel[i] = (wheel[i] - 1) == -1 ? 7 : wheel[i] - 1;
						} else {
							wheel[i] = (wheel[i] + 1) % 8;

						}
					}
				}

			}

			for (int i = 0; i < 4; i++) {
				if (wheelInfo[i][wheel[i]] == 1) {
					answer += answers[i];
				}
			}

			System.out.println("#" + test + " " + answer);
		}
		sc.close();
	}
}