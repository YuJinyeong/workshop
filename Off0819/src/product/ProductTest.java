package product;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl pm = ProductMgrImpl.getInstance();
		
		pm.search();

		// 상품정보 저장
		try {
			TV tv = new TV("a123", "led", 100, 30, 47);
			pm.add(tv);
			Refrigerator rf = new Refrigerator("112233", "4door", 500, 1000, 50);
			pm.add(rf);
			pm.save();
		} catch (DuplicateException e) {
			e.printStackTrace();
		}

		// 상품번호로 상품 검색
		try {
			pm.searchByNum("1111");
		} catch (CodeNotFoundException e) {
			e.printStackTrace();
		}

		// 400L 이상의 Refrigerator 검색
		try {
			pm.searchRef400();
		} catch (ProductNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 50inch 이상의 TV 검색
		try {
			pm.searchTv50();
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

	}
}
