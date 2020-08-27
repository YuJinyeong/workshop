
import java.util.Arrays;
import java.util.Scanner;

// nPr : nPn에서 n을 r로 보면 똑같다.
public class P2_BooleanArrayTest {

	// 1,2,3
	// 3P2 = 3!/1!= 6
	// 1,2,3
	// 3P3 = 3!
	static int N,R;
	static int[] input,numbers;
	static boolean[] selected;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		selected = new boolean[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; ++i) {
			if(selected[i]) continue;
			numbers[cnt] = input[i];
			selected[i] = true;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
}
