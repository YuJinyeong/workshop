import java.util.Scanner;
import java.util.Stack;

public class browser {

	public static void main(String[] args) {
		// V http://blabal... 해당 url 방문
		// F 포워드
		// B 백워드
		// Q 종료

		Stack<String> backward = new Stack<>();
		Stack<String> forward = new Stack<>();
		String current = "http://ssafy.com";

		Scanner sc = new Scanner(System.in);

		while (true) {
			String input = sc.next();
			out: switch (input) {
			case "Q":
				break out;
			case "V":
				// 어딘가를 방문하면 forward는 모두 폐기됨
				forward.clear();
				// 현재 페이지는 backward에 들어가게 됨
				current = sc.next();
				System.out.println(current);
				break;
			case "F":
				// 포워드가 비어있으면 처리 불가
				if (forward.isEmpty())
					System.out.println("처리불가");
				else {
					// 현재 페이지를 백워드에 push하고
					backward.push(current);
					// 포워드로부터 하나 pop해서 현재페이지로 만듬
					current = forward.pop();
					System.out.println(current);
				}
				break;
			case "B":
				// 백워드가 비어있으면 처리 불가
				if(backward.isEmpty())
					System.out.println("처리불가");
				else {
					// 현재 페이지를 포워드에 push하고
					forward.push(current);
					// 백워드로부터 하나 pop해서 현재페이지로 만듬
					current = backward.pop();
					System.out.println(current);
				}
				break;

			default:
				break;
			}
		}

	}

}
