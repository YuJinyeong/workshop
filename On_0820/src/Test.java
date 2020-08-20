import java.util.List;

public class Test {
	static BookDao bd;

	public static void main(String[] args) {
		bd = new BookDao();
		
		// 1. 아래의 데이터를 입력하세요.
		bd.insertBook(new Book("a1101", "JAVA 기본", "싸피 기술연구소", "싸피 출판사", 23000, "기본"));
		bd.insertBook(new Book("a1102", "JAVA 중급", "싸피 기술연구소", "싸피 출판사", 25000, "중급"));
		bd.insertBook(new Book("a1103", "JAVA 실전", "싸피 기술연구소", "싸피 출판사", 30000, "실전"));
		
		
		// 2. 현재 도서 목록을 출력하세요.
		printAllBooks(bd.getBookList());
		
		// 3. a1101 도서를 검색해보세요.
		bd.findBook("a1101");
		
		// 4. a1104 도서를 추가하세요.
		bd.insertBook(new Book("a1104", "JAVA 심화", "싸피 기술연구소", "싸피 출판사", 28000, "심화"));
		
		// 5. a1102 도서를 수정 후 목록을 출력하세요.
		bd.updateBook(new Book("a1101", "JAVA 기본", "싸피 기술연구소", "싸피 출판사", 20000, "기본"));
		printAllBooks(bd.getBookList());
		
		// 6. a1103 도서를 삭제 후 목록을 출력하세요.
		Book b = bd.findBook("a1103");
		bd.deleteBook(b);
		printAllBooks(bd.getBookList());
		
	}

	private static void printAllBooks(List<Book> list) {
		System.out.println(" ==================== 목록 ==================== ");
		for (Book b : list) {
			System.out.println(b.toString());
		}
	}
}
