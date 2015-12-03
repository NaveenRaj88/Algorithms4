package com.chap01;

import java.util.Iterator;

import com.util.StdIn;
import com.util.StdOut;

public class FixedCapacityStack<Item> implements Iterable<Item>{

	private Item[] items;

	private int size = 0;

	public FixedCapacityStack(int capacity) {
		items = (Item[]) new Object[capacity];
	}

	public void push(Item item) {
		items[size++] = item;
	}

	public Item pop() {
		return items[--size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isFull(){
		return size == items.length;
	}
	public static void main(String[] args) {
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class ReverseIterator implements Iterator<Item>{
		
		private int i = size;
		@Override
		public boolean hasNext() {
			return i >0;
		}

		@Override
		public Item next() {
			return items[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
