import java.util.Arrays;
import java.util.Scanner;

// 백준 Q.1931 회의실배정
public class 회의실배정 {
	static class Meeting implements Comparable<Meeting> {
		int from;
		int to;

		public Meeting(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Meeting o) {
			int rst = Integer.compare(this.to, o.to);
			if (rst == 0)
				rst = Integer.compare(this.from, o.from);
			return rst;
		}
	}

	static Meeting[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new Meeting[N];
		for (int n = 0; n < N; n++) {
			list[n] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(list);

		int result = 1;
		int end = list[0].to;
		for(int i=1; i<N; i++) {
			if(end <= list[i].from) {
				result += 1;
				end = list[i].to;
			}
		}
		System.out.println(result);
	}

}
