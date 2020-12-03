import java.util.Scanner;
 
public class SWEA2105����Ʈī�� {
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
    //����Լ��� �������� : ������ ���� ���� �̵����̸鼭, ó�� ����ߴ� �� ��ǥ�� ����.
     
    //����Լ��� �������� : �������� ������������ �湮���� �ʾҴٸ� ȣ��
     
}
