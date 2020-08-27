import java.util.Arrays;
// 비트 마스킹 : BFS에서 유용
public class 순열 {
	static int[] arr = {1, 3, 5};
	static int[] sel = new int[3]; //arr과 같은 크기
	static int check;
	static int N = 3;
	
//	//idx번째에 대해서 어떤 숫자를 고를까
//	static void perm(int idx) {
//		//모두 골랐다.
//		if(idx == N) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
//		for(int i=0; i<N ;i++) {
//			//안 고른 놈에 대해서만
//			if((check&(1<<i)) == 0) {
//				check |= (1<<i);
//				sel[idx] = arr[i];
//				perm(idx+1);
//				check &= ~(1<<i);
//			}
//		}
//	}
	
	static void perm(int idx, int check) {
//		result[check] = 기록;
		
		//모두 골랐다.
		if(idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for(int i=0; i<N ;i++) {
			//안 고른 놈에 대해서만
			if((check&(1<<i)) == 0) {
				sel[idx] = arr[i];
				perm(idx+1, check | (1 << i));
			}
		}
	}
	
	public static void main(String[] args) {
		perm(0, 0);
	}
}
