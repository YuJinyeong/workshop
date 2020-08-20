package book;

import java.util.ArrayList;
import java.util.Iterator;

public class BookMgrImpl implements IBookMgr {

	private static ArrayList<Book> list;
	private static BookMgrImpl instance;

	private BookMgrImpl() {
		list = new ArrayList<Book>();
	}

	public static BookMgrImpl getInstance() {
		if (instance == null) {
			instance = new BookMgrImpl();
		}
		return instance;
	}

	@Override
	// 도서 최초 입력 기능
	public void add(Book b) {
		list.add(b);
		System.out.println(b.getTitle() + " 추가 완료");
	}

	@Override
	// 전체 도서 정보 출력 가능
	public ArrayList<Book> search() {
		return list;
	}

	@Override
	// 도서가 판매되어 재고 수량을 빼는 기능
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book target = null;
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				target = b;
			}
		}
		if(target == null)
			throw new ISBNNotFoundException(isbn);
		if(target.getQuantity() < quantity)
			throw new QuantityException(quantity - target.getQuantity());
		target.setQuantity(target.getQuantity() - quantity);
		
//		Iterator<Book> iterator = list.iterator();
//		boolean find = false;
//		while (iterator.hasNext()) {
//			Book b = iterator.next();
//			if (b.getIsbn().equals(isbn)) {
//				find = true;
//				if (b.getQuantity() < quantity) {
//					throw new QuantityException(quantity);
//				}
//				else
//					b.setQuantity(b.getQuantity() - quantity);
//			}
//		}
//		if(!find)	throw new ISBNNotFoundException(isbn);
	}


	@Override
	// 도서가 구매되어 재고 수량을 더하는 기능
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book target = null;
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				target = b;
			}
		}
		if(target == null)
			throw new ISBNNotFoundException(isbn);
		target.setQuantity(target.getQuantity() + quantity);
		
//		Iterator<Book> iterator = list.iterator();
//		boolean find = false;
//		while (iterator.hasNext()) {
//			Book b = iterator.next();
//			if (b.getIsbn().equals(isbn)) {
//				find = true;
//				b.setQuantity(b.getQuantity() + quantity);
//			}
//		}
//		if(!find)	throw new ISBNNotFoundException(isbn);
	}

	@Override
	public int getTotalAmount() {
		Iterator<Book> iterator = list.iterator();
		int total = 0;
		while(iterator.hasNext()) {
			Book b = iterator.next();
			total += b.getPrice() * b.getQuantity();
		}
		return total;
	}

}
