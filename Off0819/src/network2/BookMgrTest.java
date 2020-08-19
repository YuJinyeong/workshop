package network2;
import java.util.Scanner;

public class BookMgrTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IBookMgr mgr = BookMgrImpl.getInstance();

		while (true) {
			System.out.println("\n----------");
			System.out.println("1. 추가 2. 다 보기 3. 팔기 4. 사기 5. 총량 6. 저장 0. 종료");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("도서 종류 입력 (1:책, 2:잡지)");
				int sel = sc.nextInt();
				if (sel != 1 && sel != 2)
					continue;
				System.out.println("도서 번호 입력");
				String isbn = sc.next();
				System.out.println("도서 제목 입력");
				String title = sc.next();
				System.out.println("도서 가격 입력");
				int price = sc.nextInt();
				System.out.println("도서 개수 입력");
				int quantity = sc.nextInt();
				if (sel == 1)
					mgr.add(new Book(isbn, title, price, quantity));
				else {
					System.out.println("잡지 년 입력");
					int year = sc.nextInt();
					System.out.println("잡지 월 입력");
					mgr.add(new Magazine(isbn, title, price, quantity, sc.nextInt()));
				}
			} else if (input == 2) {
				for (Book b : mgr.list())
					System.out.println(b.toString());
			} else if (input == 3) {
				System.out.println("판매하려는 도서 번호 입력");
				String isbn = sc.next();
				System.out.println("판매하려는 개수 입력");
				try {
					mgr.sell(isbn, sc.nextInt());

				} catch (QuantityException e) {

					System.out.println(e.getMessage());

				} catch (ISBNNotFoundException e) {

					System.out.println(e.getMessage());

				}

			} else if (input == 4) {

				System.out.println("구매하려는 도서 번호 입력");

				String isbn = sc.next();

				System.out.println("구매하려는 개수 입력");

				try {

					mgr.buy(isbn, sc.nextInt());

				} catch (ISBNNotFoundException e) {

					System.out.println(e.getMessage());

				}

			} else if (input == 5) {

				System.out.println("총 재고는 " + mgr.getTotalAmount() + "입니다.");

			} else if (input == 6) {
				//저장하자
				mgr.save();
			} else if (input == 0) {
				System.out.println("종료");

				break;

			}

		}

	}

}