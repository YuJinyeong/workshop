import java.util.Scanner;

public class q9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] D = new int[12];
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i=4; i<12; i++) {
			D[i] = D[i-3] + D[i-2] + D[i-1];
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(D[sc.nextInt()]);
		}
	}

}
