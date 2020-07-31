import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {

	static int[] arr;
	static int[] sel;
	static int N = 9;
	static int R = 7;
	static boolean flag = false;
	
	public static void combination(int idx, int idx_s) {
		if(idx_s == R) {
			// ㅇㅋ 7마리의 키를 더해서 100이 되는지 보자
			int sum = 0;
			for(int i = 0; i<R; i++) {
				sum += sel[i];
			}
			if(sum == 100) {
				int[] ans = sel.clone();
				Arrays.sort(ans);
				for(int i=0; i<R; i++)
					System.out.println(ans[i]);
				flag = true;
			}
			return;
		}
		if(idx == N) 
			return;
		sel[idx_s] = arr[idx];
		combination(idx + 1, idx_s + 1);
		combination(idx + 1, idx_s);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		sel = new int[R];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0);
	}

}
