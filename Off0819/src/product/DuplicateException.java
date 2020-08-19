package product;

class DuplicateException extends Exception {
	public DuplicateException() {
		super("이미 존재하는 상품입니다.");
	}
}

class CodeNotFoundException extends Exception{
	public CodeNotFoundException() {
		super("상품 번호가 존재하지 않습니다.");
	}
}

class ProductNotFoundException extends Exception{
	public ProductNotFoundException() {
		super("상품이 존재하지 않습니다.");
	}
}
