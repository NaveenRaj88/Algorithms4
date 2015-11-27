package com.chap01;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] items;
	private int size = 0;

	public ResizingArrayStack(int cap) {
		items = (Item[]) new Object[cap];
	}

	public void push(Item item) {
		if (size == items.length) {
			resize(2 * items.length);
		}
		items[size++] = item;
	}

	public Item pop() {
		Item item = items[--size];
		items[size] = null;
		if (size > 0 && size == items.length / 4) {
			resize(items.length / 2);
		}
		return item;
	}

	private void resize(int resizeCap) {
		Item[] newItems = (Item[]) new Object[resizeCap];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = size;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return items[--i];
		}

		@Override
		public void remove() {

		}

	}
}
