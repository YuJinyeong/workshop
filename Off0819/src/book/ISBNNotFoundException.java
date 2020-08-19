package book;
public class ISBNNotFoundException extends RuntimeException{
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		super(isbn + "을 찾을 수 없습니다.");
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
}
