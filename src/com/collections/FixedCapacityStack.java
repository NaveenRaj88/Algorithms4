package com.collections;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

	private Item[] a;
	private int n;

	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void push(Item item) {
//		if (n == a.length) resize(2*a.length);
		
		a[n++] = item;
	}

	public Item pop() {
//		String item = a[--N];
//		a[N] = null; // Avoid loitering (see text).
//		if (N > 0 && N == a.length/4) resize(a.length/2);
//		return item;
		
		return a[--n];
	}

	private void resize(int max) { // Move stack of size N <= max to a new array
									// of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < n; i++)
			temp[i] = a[i];
		a = temp;
	}

	

	public static void main(String[] args) {
		String inp = "to be or not to - be - - that - - - is";
		FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
		for (String item : inp.split(" ")) {
			if (!item.equals("-")) {
				s.push(item);
			} else {
				System.out.println(s.pop() + " ");
			}

		}
		System.out.println("(" + s.size() + " left on stack");
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReversibleIterator();
	}
	public class ReversibleIterator implements Iterator<Item>{
		private int i =n;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>n;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {
			
		}
		
	}
}
