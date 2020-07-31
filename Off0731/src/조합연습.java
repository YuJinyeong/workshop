import java.util.Arrays;

public class 조합연습 {
	static int[] arr = {1, 2, 3};
	static int N = 3;
	static int R = 2;
	static int[] sel = new int[2];
	
	static void comb(int arr_idx, int sel_idx) {
		if(sel_idx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(arr_idx == N) {
			return;
		}
		sel[sel_idx] = arr[arr_idx];
		comb(arr_idx+1, sel_idx+1);
		comb(arr_idx+1, sel_idx);
	}

	public static void main(String[] args) {
		comb(0, 0);
	}

}
