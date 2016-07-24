package com.chap01;

public class Node<Item> {

    public Item item;
    public Node<Item> nextNode;
//	public Node prevNode;

    public Node(Item item) {
        this.item = item;
    }
}
