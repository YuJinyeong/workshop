import java.util.Arrays;

public class 조합 {

	static int[] arr = {1, 2, 3};
	static int N = 3;
	static int R = 2;
	static int[] sel = new int[2];

	static void comb(int idx, int s_idx) {
		if(s_idx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		sel[s_idx] = arr[idx];
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
		
	}

	
	public static void main(String[] args) {
		comb(0, 0);
	}

}