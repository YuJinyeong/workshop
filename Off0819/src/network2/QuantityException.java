package network2;
public class QuantityException extends RuntimeException{
	private int quantity;
	public QuantityException(int quantity) {
		super(quantity+ "개수는 부족함..");
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
}
