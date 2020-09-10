import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6_2117_홈방범서비스 {

	static int N, M, map[][], cost[]; // map: 도시정보, cost: 운영비용
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;

		cost = new int[21];
		for (int k = 0; k < 21; k++) { // k: 기준점에서 떨어진 정도
			cost[k] = (k + 1) * (k + 1) + k * k;
		} // 가능한 모든 k의 운영비용 계산

		for (int t = 1; t <= TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					sum += map[i][j]; // 집의 개수를 카운트(0: 덧셈에 변화 안줌)
				}
			} // end input

			System.out.println("#" + t + " " + process());
		} // end TC

	} // end main

	private static int process() {
		int max = 0;

		for (int k = 0; k <= N; k++) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					// 마름모 영역 계산
					// 기준행
					int sj = j - k, ej = j + k;
					for (int b = sj; b <= ej; b++) {
						if (b >= 0 && b < N && map[i][b] == 1)
							++cnt;
					}

					// 기준행의 위/아래를 처리
					for (int c = 1; c <= k; c++) {
						sj = j - (k - c);
						ej = j + (k - c);
						for (int b = sj; b <= ej; b++) {
							if (b >= 0 && b < N && i - c >= 0 && map[i - c][b] == 1)
								++cnt; // i행 기준으로 c만큼 윗행
							if (b >= 0 && b < N && i + c < N && map[i + c][b] == 1)
								++cnt; // i행 기준으로 c만큼 아래행
						}
					}
					
					// 구한 집의 개수를 이용하여 지불비용을 계산하여 운영비용과 수지타산
					if(M*cnt >= cost[k]) {
						if(max<cnt) max=cnt; //최대 집 수 갱신
					}
					

				}
			}
		}

		return max;
	}

}
