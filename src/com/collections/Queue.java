package com.collections;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int n;

	private class Node {
		private Item item;
		private Node next;
	}

	private boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		n++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}

	public static void main(String[] args) {
		String inp = "to be or not to - be - - that - - - is";
		Queue<String> s = new Queue<>();
		for (String string : inp.split(" ")) {
			if (!string.equals("-")) {
				s.enqueue(string);
			} else {
				System.out.println(s.dequeue());
			}
		}
		System.out.println("(" + s.size() + " left on stack)");

	}

	@Override
	public Iterator<Item> iterator() {
		return null;
	}
	
	private class QueueIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			
		}
		
	}
}
