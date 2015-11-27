package com.collections;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int n;

	private class Node {
		private Item item;
		private Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node oldLast = first;
		first = new Node();
		first.item = item;
		first.next = oldLast;
		n++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	public class ListIterator implements Iterator<Item> {
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
			// TODO Auto-generated method stub

		}

	}
}
