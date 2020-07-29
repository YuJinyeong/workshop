
public class Àç±ÍÇÔ¼ö {
	static int[] arr = {1, 3, 5}; 

	static void recur(int n, int sum) {
		if(n == 3) {
			System.out.println(sum);
			return;
		}
		recur(n+1, sum + arr[n]);
		recur(n+1, sum);
	}
	public static void main(String[] args) {
		recur(0, 0);
	}

}