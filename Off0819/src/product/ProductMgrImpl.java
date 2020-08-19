package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import book.Book;

public class ProductMgrImpl implements IProductMgr {

	private static ProductMgrImpl instance;
	ArrayList<Product> list = new ArrayList<>();

	private ProductMgrImpl() 
	{// 리스트를 새로 만드는 게 아니라 파일로부터 읽어서 리스트를 복구!
		try {
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("product.dat"));
			list = (ArrayList<Product>) oi.readObject();
		} catch (Exception e) {
			list = new ArrayList<>();
		}
	}

	public static ProductMgrImpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl();
		}
		return instance;
	}

	@Override
	public void add(Product p) throws DuplicateException {
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product nxt = iter.next();
			if (nxt.getNum().equals(p.getNum())) {
				throw new DuplicateException();
			}
		}
		list.add(p);
	}

	@Override
	public void search() {
		System.out.println();
		System.out.println("---------------------------- 상품 정보 ----------------------------");
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}

	@Override
	public void searchByNum(String num) throws CodeNotFoundException {
		System.out.println();
		System.out.println("--------------------------- 번호 검색 결과 --------------------------");
		Iterator<Product> iter = list.iterator();
		boolean flag = false;
		while (iter.hasNext()) {
			Product p = iter.next();
			if (num.equals(p.getNum())) {
				System.out.println(p.toString());
				flag = true;
			}
		}
		if (!flag)
			throw new CodeNotFoundException();
	}

	@Override
	public void searchByName(String name) {
		System.out.println();
		System.out.println("--------------------------- 이름 검색 결과 --------------------------");
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getName().contains(name)) {
				System.out.println(p.toString());
			}
		}
	}

	@Override
	public void searchTv() {
		System.out.println();
		System.out.println("---------------------------- TV 정보 ----------------------------");
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if ("TV".equals(p.getClass().getName()))
				System.out.println(p.toString());
		}
	}

	@Override
	public void searchRef() {
		System.out.println();
		System.out.println("---------------------------- Ref 정보 ---------------------------");
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if ("Refrigerator".equals(p.getClass().getName()))
				System.out.println(p.toString());
		}
	}

	@Override
	public void searchTv50() throws ProductNotFoundException {
		System.out.println();
		System.out.println("------------------------ 50인치 이상 TV 정보 ------------------------");
		Iterator<Product> iter = list.iterator();
		boolean flag = false;
		while (iter.hasNext()) {
			Product p = iter.next();
			if ("TV".equals(p.getClass().getName()) && p.getSize() >= 50) {
				flag = true;
				System.out.println(p.toString());
			}
		}
		if (!flag)
			throw new ProductNotFoundException();
	}

	@Override
	public void searchRef400() throws ProductNotFoundException {
		System.out.println();
		System.out.println("------------------------- 400L 이상 Ref 정보 -----------------------");
		Iterator<Product> iter = list.iterator();
		boolean flag = false;
		while (iter.hasNext()) {
			Product p = iter.next();
			if ("Refrigerator".equals(p.getClass().getName()) && p.getSize() >= 400) {
				flag = true;
				System.out.println(p.toString());
			}
		}
		if (!flag)
			throw new ProductNotFoundException();
	}

	@Override
	public void modify(String num, int price) {
		System.out.println();
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (num.equals(p.getNum())) {
				System.out.println("------------------------- 수정 전 상품 정보 --------------------------");
				System.out.println(p.toString());

				p.setPrice(price);
				System.out.println("------------------------- 수정 후 상품 정보 --------------------------");
				System.out.println(p.toString());
			}
		}

	}

	@Override
	public void del(String num) {
		System.out.println();
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (num.equals(p.getNum())) {
				iter.remove();
			}
		}
		System.out.println("---------------------------- 삭제 완료 ----------------------------");
	}

	@Override
	public void calc() {
		System.out.println();
		System.out.println("----------------------------- 총 금액 ----------------------------");
		int tot = 0;
		Iterator<Product> iter = list.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			tot += p.getPrice() * p.getQuant();
		}
		System.out.println("전체 재고 상품 금액: " + tot);
	}

	@Override
	public void save() {
		new Thread(new Runnable() {
			ObjectOutputStream bo;
			public void run() {
				try {
					bo = new ObjectOutputStream(new FileOutputStream("product.dat"));
					bo.writeObject(list);
					bo.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if (bo != null) {
						try {
							bo.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}

}
