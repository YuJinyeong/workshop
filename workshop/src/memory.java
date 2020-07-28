
import java.util.Scanner;

public class memory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			char[] origin = sc.next().toCharArray();
			int[] recov = new int[origin.length];
			
			int cnt = 0;

			for(int i=0; i<origin.length; i++) {
				if(recov[i] == (origin[i]-'0')) {
					continue;
				}else {
					cnt++;
					for(int j=i; j<origin.length; j++){
						recov[j] = (origin[i]-'0');
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}

}
