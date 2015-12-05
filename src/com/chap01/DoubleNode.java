package com.chap01;

public class DoubleNode<Item> {

	public Item item;
	public DoubleNode<Item> nextNode;
	public DoubleNode<Item> prevNode;

	public DoubleNode(Item item) {
		this.item = item;
	}

}
