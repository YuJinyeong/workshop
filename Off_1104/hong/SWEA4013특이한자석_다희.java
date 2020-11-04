package hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4013특이한자석_다희 {

static int K, map[][], info[][], ans;
static boolean change[];

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());

    for (int tc = 1; tc <= T; tc++) {
        map = new int[5][8]; // 1~4번자석
        K = Integer.parseInt(in.readLine()); // 회전정보 수
        info = new int[K][2];
        // 자석정보 입력
        for (int i = 1; i <= 4; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        } // 회전 정보 입력받음.

        
        
        // 회전정보 받은 만큼 돌아.
        for (int i = 0; i < K; i++) {
            // 닿아있는 부분 체크
            check();
            // 해당 정보 회전시켜
            rotation(info[i][0], info[i][1]);
            int dir_r = info[i][1];
            // 오른쪽으로 가보고 회전
            for (int j = info[i][0]; j <= 3; j++) {
                if(!change[j]) break;
                // 바꿔야한다면
                if (change[j]) {
                    dir_r *= -1;
                    rotation(j + 1, dir_r);
                }
                    
            }

            int dir_l = info[i][1];
            // 왼쪽으로 가보고 회전
                for (int j = info[i][0]-1; j >= 1; j--) {
                    if(!change[j]) break;
                    // 바꿔야한다면
                    if (change[j]) {
                        dir_l *= -1;
                        rotation(j , dir_l); 
                    } 
                }

        }

        // 합 계산하기.
        System.out.println("#" + tc + " " + sum());

    }
}

private static void check() {
    change = new boolean[4]; // 1~3
    for (int i = 1; i <= 3; i++) {
        if (map[i][2] != map[i + 1][6])
            change[i] = true; // N, S면 true;
    }

}

// 회전하기
private static void rotation(int m, int dir) {
    if (dir == 1) { // 시계방향회전
        int tmp = map[m][7];
        for (int i = 7; i >= 1; i--) {
            map[m][i] = map[m][i - 1];
        }
        map[m][0] = tmp;
    } else { // 반시계방향 회전 //dir == -1
        int tmp = map[m][0];
        for (int i = 0; i <= 6; i++) {
            map[m][i] = map[m][i + 1];
        }
        map[m][7] = tmp;
    }
}

// 합 계산
private static int sum() {

    int sum = 0;
    for (int i = 1; i <= 4; i++) {
        if (map[i][0] == 1) {
            if (i == 1)
                sum += 1;
            else if (i == 2)
                sum += 2;
            else if (i == 3)
                sum += 4;
            else if(i == 4)
                sum += 8;
        }
    }
    return sum;
}
}
