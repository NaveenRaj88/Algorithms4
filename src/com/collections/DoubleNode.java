package com.collections;

public class DoubleNode<Item> {

	private Node first;
	private Node last;
	private int n;
	
	private class Node{
		private Item item;
		private Node previous;
		private Node next;
	}
	
	public void push(Item item){
		Node newNode = new Node();
		newNode.item = item;
		if(first == null){
			first = newNode;
			last = first;
		}else{
		first.previous=newNode;
		newNode.next=first;
		first = newNode;
		}
		n++;
	}
	
	public void addEnd(Item item){
		if(first != null){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.previous = oldLast;
		oldLast.next = last;
		}else{
			first = new Node();
			first.item =item;
			last = first;
		}
		n++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		first.previous = null;
		n--;
		return item;
	}
	
	public Item popLast(){
		Item item = last.item;
		last=last.previous;
		last.next = null;
		n--;
		return item;
	}
	
	public void insert(Item item){
		
	}
	
}
