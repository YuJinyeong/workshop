import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class card2_queue {
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		for (int i = 0; i < N; i++) {
			if (queue.size() == 1) {
				System.out.println(queue.poll());
				break;
			}
			queue.poll();
			queue.add(queue.poll());
		}
	}

}