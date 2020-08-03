package com.ssafy.live04;

public class Node {
	// 데이터 필드
	String data;
	// 링크 필드
	Node link;
	
	public Node(String data) {
		this.data = data;
	}

	public Node(String data, Node link) {
//		this(data);
		this.data = data;
		this.link = link;
	}
	
	
}
