package ct;
import java.util.Arrays;
public class Perm4 {
	static int[] A={1,2,3,4,5,6};
	static int N, R;
	static int T;
	public static void main(String[] args) {
		N=A.length;
		R=3;
		T=0;
		nPr(0, new int[R] );
		System.out.println(T);
	}
	// 콤비네이션을 구한후 구한것을 자리배치(스왑으로)
	public static void nPr(int cnt, int[] B) {
		if(cnt==R){
			T++;
			System.out.println(Arrays.toString(B));
			return ;
		}
		for (int i = cnt; i < N; i++) {
			B[cnt]=A[i];
			// 1 2 3 -> 
			int temp=A[cnt];
			A[cnt]=A[i];
			A[i]=temp;
			nPr(cnt+1, B);
			
			temp=A[cnt];
			A[cnt]=A[i];
			A[i]=temp;
		}
	}

}
