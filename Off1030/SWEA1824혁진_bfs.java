import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1824ÇõÁø_bfs {

    //0¿ì 1ÇÏ 2 ÁÂ 3 »ó 
    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    static class Point{
        int x;
        int y;
        int d;
        int num;
        public Point(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }

    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int tc = 1 ; tc <= T ; tc ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char map[][] = new char[N][M];
            for(int i = 0 ; i < N ; i++) {
                String S = br.readLine();
                for(int j =0 ; j < M ; j++) {
                    map[i][j] = S.charAt(j);
                }
            }
            boolean end = false;
            boolean visit[][][][] = new boolean [N][M][4][16];
            visit[0][0][0][0] = true;
            Queue<Point> que = new LinkedList<Point>();
            que.add(new Point(0, 0, 0, 0));

            while(!que.isEmpty()) {
                Point now = que.poll();
                int dir = now.d;
                int num = now.num;
                char some = map[now.x][now.y];
                if('0'<=some && some<= '9') {
                    num = Integer.parseInt(some+"");
                }else if(some == '<'){
                    dir = 2;
                }else if(some == '>') {
                    dir = 0;
                }else if(some == '^') {
                    dir = 3;
                }else if(some == 'v') {
                    dir = 1;
                }else if(some == '_') {
                    dir = num ==0 ? 0 : 2;
                }else if(some == '+') {
                    num = num == 15 ? 0: num+1;
                }else if(some == '-') {
                    num = num == 0 ? 15: num-1;
                }else if(some == '|') {
                    dir = num ==0 ? 1 : 3;
                }
                if(some == '?') {
                    for(int i = 0 ; i < 4 ; i++) {
                        visit[now.x][now.y][i][num] = true;
                        int row = now.x+dr[i];
                        int col = now.y+dc[i];
                        row = row <0 ? N-1 : row;
                        row = row >=N ? 0 : row;
                        col = col <0 ? M-1 : col;
                        col = col >=M ? 0 : col;

                        if(visit[row][col][i][num])
                            continue;
                        visit[row][col][i][num] = true;
                        que.offer(new Point(row, col, i, num));
                    }
                    continue;
                }else if(some == '@') {
                    end = true;
                    break;
                }
                int row = now.x+dr[dir];
                int col = now.y+dc[dir];
                row = row <0 ? N-1 : row;
                row = row >=N ? 0 : row;
                col = col <0 ? M-1 : col;
                col = col >=M ? 0 : col;
                if(visit[row][col][dir][num])
                    continue;
                visit[row][col][dir][num] = true;
                que.offer(new Point(row,col,dir,num));
            }


            System.out.println("#"+tc+" "+ (end ? "YES":"NO"));

        }

    }

}