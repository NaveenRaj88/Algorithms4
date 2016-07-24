package com.chap01;

public class Steque<Item> {

	private Node<Item> first;
	private Node<Item> last;
	
	private int size=0;
	
	public void push(Item item){
		Node<Item> node = new Node<>(item);
		node.nextNode=first;
		first=node;
		size++;
	}
	
	public void enqueu(Item item){
		Node<Item> node = new Node<>(item);
		if(last == null){
			last = node;
		}else{
			last.nextNode= node;
			last = node;
		}
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.nextNode;
		return item;
	}
	
	public static void main(String[] args) {
		
	}
}
