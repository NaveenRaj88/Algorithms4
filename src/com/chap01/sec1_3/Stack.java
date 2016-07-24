package com.chap01.sec1_3;

import com.chap01.Node;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private Node<Item> head;
	private int size;
	
	//create an empty stack
	public Stack(){
		
	}
	
	// add an item
	public void push(Item t){
		Node<Item> node = new Node<>(t);
		if(head == null){
			head=node;
		}else{
			node.nextNode=head;
			head=node;
		}
		size++;
	}
	
	public Item peek(){
		return head.item;
	}

	// remove the most recently added item
	public Item pop(){
		Node<Item> temp = head;
		head=head.nextNode;
		size--;
		return temp.item;
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
		return new stackIterator<>();
	}
	
	private class stackIterator<Item> implements Iterator<Item>{
		
		Node<Item> current = (Node<Item>) head;
		
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item val = current.item;
			current = current.nextNode;
			return val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
