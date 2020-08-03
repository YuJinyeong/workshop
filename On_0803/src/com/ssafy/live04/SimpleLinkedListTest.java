package com.ssafy.live04;

public class SimpleLinkedListTest {

	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		
		list.addFirstNode("이주헌");
		list.printList();
		list.addFirstNode("이민혁");
		list.printList();
		list.addFirstNode("손현우");
		list.printList();
		list.addFirstNode("채형원");
		list.printList();
		// 스택의 PUSH를 구현한 것임을 알 수 있다.
		
		list.deleteFirstNode();
		list.printList();
	}

}
