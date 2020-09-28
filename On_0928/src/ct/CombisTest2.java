package ct;

import java.util.Arrays;

public class CombisTest2 {

	static int N;
	static int R;
	static int[] num;
	static boolean[] v;
	
	public static void main(String[] args) {
		num=new int[]{1,2,3,4,5};
		N=num.length;
		R=3;
		v=new boolean[N];
		nCr(0,0, new int[R]);
	}

	public static void nCr(int start, int cnt, int [] a) {
		
		if(cnt==R){
			System.out.println(Arrays.toString(a));
		    return ;
		}
		for (int i = start; i < N; i++) {

			a[cnt]=num[i];
			nCr(i+1, cnt+1, a);
			
		}
		
	}

}
