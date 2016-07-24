package com.chap01;

import java.util.Iterator;

import com.util.ArrayUtils;

public class RandomBag<Item> implements Iterable<Item>{
	
	private Node<Item> first;
	private int size =0;
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public void add(Item item){
		Node<Item> node = new Node<>(item);
		node.nextNode = first;
		first=node;
		size++;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new bagIterator();
	}
	
	
	private class bagIterator<Item> implements Iterator<Item>{
		
		private Item[] items = (Item[]) new Object[size];
		private Node<Item> current = (Node<Item>) first;
		private int index = 0;
		public bagIterator() {
			for (int i = 0; i < size; i++) {
				items[i] = current.item;
				current = current.nextNode;
			}
			ArrayUtils.randomize(items);
		}
		
		@Override
		public boolean hasNext() {
			return index < items.length;
		}

		@Override
		public Item next() {
			return items[index++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	public static void main(String[] args) {
		RandomBag<Integer> bag = new RandomBag<>();
		bag.add(1);
		bag.add(2);
		bag.add(3);
		
		for (Integer integer : bag) {
			System.out.println(integer);
		}
	}
}
