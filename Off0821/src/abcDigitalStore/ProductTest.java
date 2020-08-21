package abcDigitalStore;

import java.util.List;

public class ProductTest {

	public static void main(String[] args) {
		ProductDao pd = new ProductDao();
		
//		pd.insert(new TV("a123", "aaa", 70, 10, 45));
//		pd.insert(new TV("b456", "bbb", 80, 5, 45));
//		pd.insert(new TV("c789", "ccc", 120, 5, 72));
//		pd.insert(new TV("c789", "ccc", 100, 5, 60));
//		pd.insert(new Refrigerator("a123", "ddd", 150, 7, 60));
//		pd.insert(new Refrigerator("gghhii", "ghi", 100, 6, 50));
//		pd.insert(new Refrigerator("jjkkll", "ddd", 300, 5, 80));
		
		showAllProducts(pd.getProductList());
		
		System.out.println("\n < name 'ddd' 검색 결과 > ");
		showAllProducts(pd.searchByName("ddd"));
		System.out.println("\n < num 'a123' 검색 결과 > ");
		showAllProducts(pd.searchByNum("a123"));
		System.out.println("\n < price 60 이하 검색 결과 > ");
		showAllProducts(pd.searchByPrice(60));
		
		pd.delete("gghhii");
		System.out.println("\n < num 'gghhii' 삭제 결과 > ");
		showAllProducts(pd.getProductList());
		
		pd.update("c789", 120, 130);
		System.out.println("\n < num 'c789', price 120 -> price 130로 수정 결과 > ");
		showAllProducts(pd.getProductList());
		
	}

	private static void showAllProducts(List<Product> list) {
		System.out.println("****************************** List ******************************");
		for(Product p : list) {
			System.out.println(p.toString());
		}
	}
	
	
}
