package ct;

import java.util.Scanner;
/*
JAVA
언어
26,516 kb
메모리
144 ms
실행시간
588
코드길이
Pass
결과
 */
public class Solution_D4_8382_방향전환 {
	static int T;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int i = 1; i <= T; i++) {
			int x1=scann.nextInt();
			int y1=scann.nextInt();
			int x2=scann.nextInt();
			int y2=scann.nextInt();
			int X=Math.abs(x2-x1);
			int Y=Math.abs(y2-y1);
			int maxX=Math.max(X, Y);
			int Kun=X+Y;  //군 (Kun,0)
			int val=0;
			if(Kun%2==0){
				val=2*Kun;  // 짝수 2k
			}else{
				val=2*Kun-1; // 홀수 2k-1
			}
			int diff=(Kun-maxX)*2;  //(군, 0)에서 중앙을 향해 한칸 이동할 때마다 2씩 줄어듦
			val=val-diff;
			System.out.println("#"+i+" "+val);
		}
	}

}
