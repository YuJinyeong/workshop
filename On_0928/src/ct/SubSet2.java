package ct;

public class SubSet2 {

	static int [] p={1,2,3,4,5,6};
	//static int sum=0;
	static int N;
	static int R;
	static boolean[] v;
	public static void main(String[] args) {
		N=p.length;
		R=3;
		v=new boolean[N];
		subset(0,0);
	}
	public static void subset(int cnt, int sum) {
		if(cnt==N){
			for (int i = 0; i < N; i++) {
				if(v[i]){
					System.out.print(p[i]+" ");
				}
			}
			System.out.println();
			System.out.println(sum);
			return ;
		}
		v[cnt]=true;
		subset(cnt+1, sum+p[cnt]);
		v[cnt]=false;
		subset(cnt+1, sum);
	}
	
}
