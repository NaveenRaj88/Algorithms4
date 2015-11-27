package com.chap01;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	
	private Node<T> head;
	private int size;
	
	//create an empty stack
	public Stack(){
		
	}
	
	// add an item
	public void push(T t){
		Node<T> node = new Node<T>(t);
		if(head == null){
			head=node;
		}else{
			node.nextNode=head;
			head=node;
		}
		size++;
	}
	
	// remove the most recently added item
	public T pop(){
		Node<T> temp = head;
		head=head.nextNode;
		size--;
		return temp.value;
	}
	
	// is the stack empty?
	public boolean isEmpty(){
		return size==0;
	}
	
	// number of items in the stack
	public int size(){
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
