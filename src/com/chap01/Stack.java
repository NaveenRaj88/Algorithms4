package com.chap01;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private Node<Item> head;
	private int size;
	
	//create an empty stack
	public Stack(){
		
	}
	
	// add an item
	public void push(Item t){
		Node<Item> node = new Node<Item>(t);
		if(head == null){
			head=node;
		}else{
			node.nextNode=head;
			head=node;
		}
		size++;
	}
	
	public Item peek(){
		return head.value;
	}
	// remove the most recently added item
	public Item pop(){
		Node<Item> temp = head;
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
	public Iterator<Item> iterator() {
		// ItemODO Auto-generated method stub
		return null;
	}
}
