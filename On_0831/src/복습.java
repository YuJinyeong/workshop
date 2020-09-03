import java.util.Arrays;

public class 복습 {
	static int[] arr = { 1, 3, 5 };
	static int N = arr.length, R = 2;
	static boolean[] check = new boolean[N];
//	static int[] sel = new int[N]; // 순열
	static int[] sel = new int[R]; // 조합

	public static void main(String[] args) {
//		perm(0); // 순열
//		comb(0, 0); // 조합
		powerSet(0); // 부분집합
	}

	// 부분집합
	private static void powerSet(int idx) {
		if(idx == N) {
			for(int i=0; i<N; i++) {
				if(check[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		check[idx] = true;
		powerSet(idx + 1);
		
		check[idx] = false;
		powerSet(idx + 1);
	}

	// 조합
	private static void comb(int idx, int idx_s) {
		if(idx_s == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N)
			return;
		
		sel[idx_s] = arr[idx];
		comb(idx+1, idx_s+1);
		comb(idx+1, idx_s);
	}

	// 순열
	private static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx+1);
				check[i] = false;
			}
		}
	}
}