package book;

class QuantityException extends RuntimeException {
	private int quantity;
	public QuantityException(int quantity) {
		super(quantity + " 개가 부족합니다.");
	}
	public int getQuantity(){
		return quantity;
	}
}

class ISBNNotFoundException extends RuntimeException {
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		super(isbn + " 을 찾을 수 없습니다.");
	}
	public String getIsbn() {
		return isbn;
	}
}