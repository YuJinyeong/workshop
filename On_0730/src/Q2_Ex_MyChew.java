import java.util.LinkedList;
import java.util.Queue;

public class Q2_Ex_MyChew {

	public static void main(String[] args) {

		Queue<int[]> queue = new LinkedList<int[]>();
		int N = 20;
		int person = 1;

		queue.offer(new int[] { 1, 1 });

		while (N > 0) {
			// 줄 서 있는 첫번째 사람에게 마이쮸 주기
			if (!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (N >= p[1]) ? p[1] : N;
				N -= availableCnt;
				if (N == 0) { // 마지막 마이쮸가 포함된 상황(더이상 마이쮸 없음)
					System.out.println("마지막 마이쮸를 가젼간 사람 : " + p[0] + ", 가져간 개수: " + availableCnt);
				} else {
					System.out.println(p[0] + "번이 " + availableCnt + " 개수만큼 가져갑니다. 남은 개수: " + N);
					++p[1];
					queue.offer(p);// 다시 줄서기
					queue.offer(new int[] { ++person, 1 });
				}
			}
		}
	}

}
