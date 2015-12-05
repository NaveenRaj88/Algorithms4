package com.chap01;

public class Deque<Item> {

	private DoubleNode<Item> first;
	private DoubleNode<Item> last;
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void pushLeft(Item item) {
		DoubleNode<Item> node = new DoubleNode<>(item);
		node.nextNode = first;
		first = node;
		size++;
	}

	public void pushRight(Item item) {
		DoubleNode<Item> node = new DoubleNode<>(item);
		node.prevNode = last;
		last = node;
		size++;
	}

	public Item popLeft() {
		Item item = first.item;
		first = first.nextNode;
		size--;
		return item;
	}

	public Item popRight() {
		Item item = last.item;
		last = last.prevNode;
		size--;
		return item;
	}
}
