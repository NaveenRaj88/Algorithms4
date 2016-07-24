package com.chap01;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item>{

	
	private Node<Item> firstNode;
	private Node<Item> lastNode;
	private int size = 0;
	private static final Random random = new Random();
	
	public RandomQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(Item item) {
		Node<Item> node = new Node<Item>(item);
		if (size == 0) {
			lastNode = node;
			firstNode = lastNode;
		} else {
			lastNode.nextNode = node;
			lastNode = node;
		}
		size++;
	}
	
	public Item dequeue(){
		int itemNo = random.nextInt(size);
		Node<Item> node = getNthNode(0, itemNo, firstNode);
		Item item = node.nextNode.item;
		node.nextNode = node.nextNode.nextNode;
		size--;
		return item;
	}
	
	public Item sample(){
		int itemNo = random.nextInt(size);
		Node<Item> node = getNthNode(0, itemNo, firstNode);
		return node.nextNode.item;
	}
	
	private Node<Item> getNthNode(int counter, int n, Node<Item> node){
		if(counter == n){
			return node;
		}
		return getNthNode(counter++, n, node.nextNode);
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class randonQueueIterator<Item> implements Iterator<Item>{
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
