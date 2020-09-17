package com.ssafy.move;

public class BookDto {

	private String isbn;
	private String bookName;
	private String publisher;
	private int price;

	public BookDto(String isbn, String bookName, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
