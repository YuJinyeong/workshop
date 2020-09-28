package ct;

import java.util.Scanner;

public class Solution_D5_9711_제곱수의합 {

	static int T;
	static int K;
	static long N;
	static int P=1000000007;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextLong();
			K=scann.nextInt();
			long sum=0L;
			
			for (long i = 1L; i <= N; i++) {
				long a=power(i,K,P);
				sum=(sum%P+(a%P))%P;
			}
			System.out.println("#"+t+" "+sum);
		}

	}
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        
        x = x % p; 
        //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
          
        return res; 
    } 
}
