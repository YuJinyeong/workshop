package hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4013특이한자석_건상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcN = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= tcN; tc++) {
            int len = Integer.parseInt(br.readLine());
            char[][] circle = new char[4][];
            for(int i = 0; i < 4; i++)
                circle[i] = br.readLine().replace(" ", "").toCharArray();
            int[] idx = new int[4];
            int[][] inp = new int[len][2];
            for(int i = 0; i < len; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                inp[i][0] = Integer.parseInt(st.nextToken())-1;
                inp[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < len; i++) {
                int cur = inp[i][0];
                int dir = inp[i][1] * -1;
                int[] tmp = idx.clone();
                tmp[cur] = (tmp[cur] + 8 + dir) % 8;
                int td = dir;
                for(int c = cur; c > 0; c--) {
                    td *= -1;
                    if(circle[c][(idx[c] + 6) % 8] != circle[c-1][(idx[c-1] + 2) % 8]) {
                        tmp[c-1] = (tmp[c-1] + 8 + td) % 8;
                    } else break;
                }
                td = dir;
                for(int c = cur; c < 3; c++) {
                    td *= -1;
                    if(circle[c][(idx[c] + 2) % 8] != circle[c+1][(idx[c+1] + 6) % 8]) {
                        tmp[c+1] = (tmp[c+1] + 8 + td) % 8;
                    } else break;
                }
                idx = tmp;
            }
            int sum = 0;
            for(int i = 0; i < 4; i++) {
                sum += (circle[i][idx[i]] - 48) * Math.pow(2, i);
            }
            System.out.println(sum);
        }
    }
}