import java.util.Scanner;
 
public class SWEA2105디저트카페 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    map[i][j] = sc.nextInt();
            }
            ans = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    boolean[] visited = new boolean[101];
                    dfs(map, visited, i, j, i, j, 0, 0);
                }
            }
            System.out.println("#" + tc + " "+ ans);
        }
    }
    static int ans = -1;
    static int[] dr = {1, 1, -1 ,-1};
    static int[] dc = {1, -1, -1, 1};
    static void dfs(int[][] map, boolean[] visited, int sr, int sc, 
            int cr, int cc,int dir, int cnt) {
        if( sr == cr && sc == cc && dir == 3) {
            ans = Math.max(ans, cnt);
            return;
        }
        for(int i = dir; i <= dir+1 && i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            if( nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length)
                continue;
            if(visited[map[nr][nc]])
                continue;
            visited[map[nr][nc]] = true;
            dfs(map, visited, sr, sc, nr, nc, i, cnt+1);
            visited[map[nr][nc]] = false;
        }
    }
    //재귀함수의 종료조건 : 오른쪽 위를 향해 이동중이면서, 처음 출발했던 그 좌표에 도달.
     
    //재귀함수의 유도조건 : 현재방향과 다음방향으로 방문하지 않았다면 호출
     
}
