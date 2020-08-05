package com.ssafy.live04;

public class SimpleLinkedList {
	private Node head;

	// 첫번째 노드로 삽입
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}

	public void printList() {
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.println(currNode.data + " ");
		}
		System.out.println();
	}
	
	// 첫번째 노드 삭제
	public void deleteFirstNode() {
		head = head.link;
	}

}
