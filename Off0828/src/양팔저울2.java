import java.util.Scanner;
 
public class 양팔저울2 {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            weights = new int[N];
            for (int i = 0; i < N; i++)
                weights[i] = sc.nextInt();
            memo = new int[1 << N][1<<N];
            System.out.println("#" + tc + " " + power(0,0, 0, 0, 0));
        }
    }
    static int[][] memo;
    static int[] weights;
    
    // static보다는 매개변수가 더 빠르다!!
    static int power(int left, int right, int idx, int lsum, int rsum) {
 
        // 끝까지 도달했으면 하나의 경우 (오른쪽에 더 무거워지는 경우는 가지치기됨)
        if (idx == weights.length)
            return 1;
        // 현재 상태( 고른패턴, 왼쪽무게합, 몇번째까지 골랐는지 )
        if (memo[left][right] != 0)
            return memo[left][right] ;
        int cnt = 0;
        // 재귀호출이 되며 1씩 늘어나는 idx 칸마다 0~N-1까지의 추를 넣어봄
        for (int i = 0; i < weights.length; i++) {
            // 아직 안넣은 추라면
            if ( (left & (1<<i)) ==0 && (right & (1<<i)) ==0 ) {
                // 왼쪽에 달아보고
                cnt += power(left | (1 << i), right, idx + 1, lsum + weights[i], rsum);
                // 오른쪽에 달 수 있다면 달아보고
                if (lsum >= rsum + weights[i]) {
                    cnt += power(left, right | (1 << i), idx + 1, lsum, rsum + weights[i]);
                }
            }
        }
 
        // 상태에 대한 결과를 저장
        memo[left][right] = cnt;
        return cnt;
    }
     
}