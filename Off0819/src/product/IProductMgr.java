package product;

public interface IProductMgr {	
	public void add(Product p) throws DuplicateException;
	public void search();
	public void searchByNum(String num) throws CodeNotFoundException;
	public void searchByName(String name);
	public void searchTv();
	public void searchRef();
	public void searchTv50() throws ProductNotFoundException;
	public void searchRef400() throws ProductNotFoundException;
	public void modify(String num, int price);
	public void del(String num);
	public void calc();
	public void save();
	
}
