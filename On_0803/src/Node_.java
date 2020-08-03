import com.ssafy.live04.Node;

public class Node_ {
	// 데이터 필드
	String data;
	// 링크 필드
	Node_ next;

	public Node_() {}
	
	public Node_(String data) {
		this.data = data;
	}

	public Node_(String data, Node_ next) {
//			this(data);
		this.data = data;
		this.next = next;
	}
}
