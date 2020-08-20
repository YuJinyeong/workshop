package network2;
import java.util.List;

public interface IBookMgr {

	void add(Book b);
	List<Book> list();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void save(); //저장하는 기능에 대한 규격
}
