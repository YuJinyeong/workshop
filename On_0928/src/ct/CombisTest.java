package ct;

import java.util.Arrays;

public class CombisTest {

	static int N;
	static int R;
	static int[] num;
	static boolean[] v;
	
	public static void main(String[] args) {
		num=new int[]{1,2,3,4,5};
		N=num.length;
		R=3;
		v=new boolean[N];
		nCr(N,R, new int[R]);
	}

	public static void nCr(int n, int r, int [] a) {
		
		if(n<r){ return ;}
		
		if(r==0){
			System.out.println(Arrays.toString(a));
			return ;
		}
		
		a[r-1]=num[n-1];
		// 파스칼의 삼각형 
		//ncr=n-1Cr-1+n-1Cr
		nCr(n-1, r-1, a);
		nCr(n-1, r, a);	
		

	}
}
