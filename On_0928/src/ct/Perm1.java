package ct;

import java.util.Arrays;

public class Perm1 {

	static int[] A={1,2,3,4,5};
	static int N, R;
	static boolean[] v;
	public static void main(String[] args) {
		N=A.length;
		R=3;
		v=new boolean[N];
		nPr(0, 0, new int[R] );
	}
	public static void nPr(int cnt, int flag, int[] B) {
		if(cnt==R){
			System.out.println(Arrays.toString(B));
			return ;
		}
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i))!=0){
				continue;
			}
			B[cnt]=A[i];
			nPr(cnt+1,(flag | (1<<i)), B);

		}
	}

}
