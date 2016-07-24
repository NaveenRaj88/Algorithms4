package com.chap01;

public class CircularLinkedList<Item> {
	
	private Node<Item> firstNode;
	private Node<Item> lastNode;
	private int size = 0;
	
	public void enqueue(Item item) {
		Node<Item> node = new Node<Item>(item);
		if (size == 0) {
			lastNode = node;
			firstNode = lastNode;
			lastNode.nextNode = firstNode;
		} else {
			lastNode.nextNode = node;
			lastNode = node;
			node.nextNode = firstNode;
		}
		size++;
	}

	// remove the least recently added item
	public Item dequeue() {
		if (size == 0) {
			return null;
		}
		Node<Item> oldFirst = firstNode;
		firstNode = firstNode.nextNode;
		lastNode.nextNode = firstNode;
		size--;
		return oldFirst.item;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// number of items in the queue
	public int size() {
		return size;
	}
	
}
