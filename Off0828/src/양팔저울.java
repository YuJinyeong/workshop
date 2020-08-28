import java.util.Arrays;

public class 양팔저울 {
	static int N = 3;
	static int[] arr = {1, 2, 4};
	static int[] sel = new int[3];//arr과 같은 크기
	static boolean[] check = new boolean[3];
	static int cnt = 0;
	static boolean[] isLeft = new boolean[3];
	static void powerSet(int idx) {
		if(idx == N) {
			int sumL = 0, sumR = 0;
			for(int i = 0; i < N; i++) {
				if(isLeft[i])
					sumL += sel[i];
				else
					sumR += sel[i];
				if( sumR > sumL )
					return;
			}
			if( sumL > sumR )
				cnt++;
			return;
		}
		isLeft[idx] = true;
		powerSet(idx + 1);
		isLeft[idx] = false;
		powerSet(idx + 1);
	}
	static void perm(int idx) {
		//모두 골랐다.
		if( idx == N ) {
			powerSet(0);
			return;
		}
		for(int i = 0; i < N; i++) {
			//안고른 놈에 대해서만
			if(!check[i]) {
				check[i] = true;//고른걸로 체크해두고
				sel[idx] = arr[i];
				perm(idx + 1);
				check[i] = false;//다시 돌아왔을땐 체크해제			
			}
		}
	}
	
	public static void main(String[] args) {
		perm(0);
		System.out.println(cnt);
	}
}
