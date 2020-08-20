package book;

import java.util.ArrayList;
import java.util.Iterator;

public class BookTest {
	static BookMgrImpl bm = BookMgrImpl.getInstance();
	static ArrayList<Book> books;
	static Iterator<Book> iter;
	
	public static void print() {
		System.out.println("전체 도서 정보 출력");
		books = bm.search();
		iter = books.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}

	public static void main(String[] args){

		System.out.println("도서 입력");
		bm.add(new Book("a123", "AAA", 35, 80));
		bm.add(new Book("b456", "BBB", 20, 55));
		bm.add(new Magazine("7896", "abb", 10, 100, 8));
		bm.add(new Magazine("5235", "ess", 12, 70, 8));

		print();

		System.out.println("도서 판매");
		try {
			System.out.println("sell(\"a123\", 50)");
			bm.sell("a123", 50); // 정상적인 판매
			print();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("sell(\"7896\", 120)");
			bm.sell("7896", 120); // 수량 부족
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("sell(\"5234\", 1)");
			bm.sell("5234", 1); // 도서 정보 없음	
		}catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("도서 구매");
		try {
			System.out.println("buy(\"a123\", 20)");
			bm.buy("a123", 20); // 정상적인 구매
			print();
			System.out.println("buy(\"456\", 100)");
			bm.buy("456", 100); // 도서 정보 없음		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("총 재고 금액은 " + bm.getTotalAmount() + "원 입니다.");
	}

}
