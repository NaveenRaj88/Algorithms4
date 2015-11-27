package com.chap01;

public class Node<T> {

	public T value;
	public Node<T> nextNode;
//	public Node prevNode;
	
	public Node(T t) {
		this.value=t;
	}
}
