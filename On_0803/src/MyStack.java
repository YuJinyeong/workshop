public class MyStack {
	Node_ head = new Node_();
	Node_ cur;

	void push(String data) {
		head.next = new Node_(data, head.next);
	}

	String pop() {
		cur = head.next;
		head.next = cur.next;
		cur.next = null;
		return cur.data;
	}

	String peek() {
		return head.next.data;
	}

	boolean isEmpty() {
		return head.next == null;
	}
}
