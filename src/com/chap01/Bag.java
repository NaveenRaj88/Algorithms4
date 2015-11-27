package com.chap01;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	
	private Node head;
	private Node tail;
	private int size;
	// create an empty bag
	public Bag() {
		
	}

	// add an item
	public <T> void add(T t) {
		Node<T> node = new Node<T>(t);
		if (head==null){
			head=node;
			tail=head;
		}else{
			tail.nextNode=node;
			tail = node;
		}
		size++;
	}

	// is the bag empty?
	public boolean isEmpty() {
		return size ==0;
	}

	// number of items in the bag
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
