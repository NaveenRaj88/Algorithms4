package com.chap01.sec1_3;

import com.chap01.Node;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node<Item> firstNode;
	private Node<Item> lastNode;
	private int size = 0;

	// create an empty queue
	public Queue() {

	}

	// add an item
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

	// remove the least recently added item
	public Item dequeue() {
		if (size == 0) {
			return null;
		}
		Node<Item> oldFirst = firstNode;
		firstNode = firstNode.nextNode;
		size--;
		return oldFirst.item;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// number of items in the queue
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator<Item>();
	}

	private class QueueIterator<Item> implements Iterator<Item> {

		private Node<Item> current = (Node<Item>) firstNode;

		@Override
		public boolean hasNext() {
			return firstNode != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.nextNode;
			return item;
		}

		@Override
		public void remove() {
		}

	}

}
