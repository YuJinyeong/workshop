import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4008. [모의 SW 역량테스트] 숫자 만들기

public class q4008 {
	static int N, cnt[], nums[], MAX, MIN;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			cnt = new int[4];
			nums = new int[N];
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<4; i++)
				cnt[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			calc(1, nums[0]);
			
			System.out.println("#" + tc + " " + (MAX - MIN));
		}
	}
	
	private static void calc(int idx, int res) {
		if(idx == N) {
			MAX = Math.max(MAX, res);
			MIN = Math.min(MIN, res);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(cnt[i]>0) { 
				cnt[i]--;
				if(i == 0) 
					calc(idx+1, res+nums[idx]);
				else if(i == 1) 
					calc(idx+1, res-nums[idx]);
				else if(i == 2) 
					calc(idx+1, res*nums[idx]);
				else if(i == 3)
					calc(idx+1, res/nums[idx]); 
				cnt[i]++;
			}
		}
		
	}
}
