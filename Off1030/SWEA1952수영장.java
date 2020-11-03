import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952수영장 {
	static int price[], month[], dMonth[], d[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			price = new int[4];
            month = new int[13];
            dMonth = new int[13];
            d = new int[13];
            
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=1; i<13; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			//min(하루요금*일수, 한달요금)
			//1~12월 월간 최소값 저장
			for(int i=1; i<13; i++) {
				dMonth[i] = Math.min(month[i]*price[0], price[1]);
			}
			
			//d[N] = N번째 날의 누적된 최소값
			for(int i=1; i<13; i++) {
				d[i] = d[i-1] + dMonth[i];
				if(i>2) {
					if(d[i] > d[i-3] + price[2])
						d[i] = d[i-3] + price[2];
				}
			}
			
			if(d[12] > price[3])
				d[12] = price[3];
			
			System.out.println("#" + tc + " " + d[12]);
		}
	}

}
