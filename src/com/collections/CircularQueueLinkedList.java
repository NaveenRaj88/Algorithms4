package com.collections;

public class CircularQueueLinkedList<Item> {

	private Node first;
	private Node last;
	private int n;

	public class Node {
		private Item item;
		private Node next;
	}
	
	public void push(Item item){
		Node oldLast  = last;
		last = new Node();
		last.item = item;
		oldLast.next = last;
		last.next=first;
	}
	
}
