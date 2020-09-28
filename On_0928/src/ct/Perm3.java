package ct;

import java.util.Arrays;

public class Perm3 {

	static int[] p={1,2,3,4,5};
	static int N, R;
	static boolean[] v;
	public static void main(String[] args) {
		N=p.length;
		R=3;
		v=new boolean[N];
		
		do {
			System.out.println(Arrays.toString(p));
		} while (np());
	}
	
	public static boolean np(){
		int size=p.length-1;
		int i=size;
		while(i>0 && p[i-1]>=p[i] )i--;
		if(i==0)return false; 
		int j=size;
		while(p[i-1]>=p[j])j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i<k){
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			j--;
		}
		return true;
	}
	
	
	
	
	
}
