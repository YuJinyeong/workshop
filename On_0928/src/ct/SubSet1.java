package ct;

public class SubSet1 {

	static int [] p={1,2,3,4,5,6};
	//static int sum=0;
	static int N;
	static int R;
	public static void main(String[] args) {
		N=p.length;
		R=N;
		subset(0,0);
	}
	public static void subset(int cnt, int sum) {
		if(cnt==R){
			System.out.println(sum);
			return ;
		}
		subset(cnt+1, sum+p[cnt]);
		subset(cnt+1, sum);
	}
	
}
