import java.util.Arrays;

public class 조합 {

	static int[] arr = {1, 2, 3};
	static int N = 3;
	static int R = 2;
	static int[] sel = new int[2];

	/*
	static void comb(위에화살표, 아래화살표) {
		if( 아래 화살표 나갔다) {
			출력
			return;
		}
		if( 위에 화살표 나갔다) {
			return;
		}
		위에 화살표 위치의 숫자를 아래 화살표 위치에 담는다
		위에 화살표 + 1, 아래 화살표 + 1로 다음 상태 호출
		위에 화살표 + 1, 아래 화살표 그대로 다음 상태 호출
	}
	*/
	
	static void comb(int idx, int s_idx) {
//		System.out.println("comb(" + idx + ", " + s_idx + ")");
		if(s_idx == R) { //2
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) { //3
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
