import java.util.Arrays;

public class 중복순열 {

	static int[] arr = {1, 3, 5};
	static int N = arr.length;
	static int[] sel = new int[N]; // arr과 같은 크기
	static boolean[] check = new boolean[N];
	
	// idx번째에 대해서 어떤 숫자를 고를까
	static void perm(int idx) {
		
		// 모두 골랐다
		if(idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true; // 고른 걸로 체크해두고
				sel[idx] = arr[i];
				perm(idx + 1);
				check[i] = false; // 다시 돌아왔을땐 체크해제
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		perm(0);
	}

}
