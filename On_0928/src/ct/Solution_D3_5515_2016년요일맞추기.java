package ct;
import java.util.Scanner;
/*
JAVA
언어
36,392 kb
메모리
199 ms
실행시간
517
코드길이
경과일+기준요일을 7나누면 요일
 */
public class Solution_D3_5515_2016년요일맞추기 {

	static int iT,M, D, pass, Friday=4;
	static int[] days= {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args)  {
		Scanner scann=new Scanner(System.in);
		iT=scann.nextInt();
		for (int T = 1; T <= iT; T++) {
			M=scann.nextInt();
			D=scann.nextInt();
			pass=0; // 1/1 
			
			for (int i = 1; i < M; i++) {
				pass+=days[i-1];
			}
			pass+=D-1;
			int dayOfWeek=(pass+Friday)%7;
			System.out.printf("#%d %d\n",T,dayOfWeek);	
		}
	}
}

/*

2
1 1
12 31

#1 4
#2 5
*/