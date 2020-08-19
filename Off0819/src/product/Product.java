package product;

import java.io.Serializable;

public class Product implements Serializable{
	private String num;
	private String name;
	private int price;
	private int quant;
	private int size;
	
	public Product(String num, String name, int price, int quant, int size) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.quant = quant;
		this.size = size;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", quant=" + quant + ", size=" + size + "]";
	}

	
}
