package com.chap01;

public class ResizingArrayQueueOfStrings {

	private int size = 0;
	private String[] arr;

	public ResizingArrayQueueOfStrings(int size) {
		arr = new String[size];
	}

	public void enQueue(String s) {
		if (isFull()) {
			resize(arr.length * 2);
		}
		arr[size++] = s;
	}

	public String deQueue() {
		if (size < arr.length) {
			resize(arr.length / 2);
		}
		return arr[--size];
	}

	private void resize(int newSize) {
		size = 0;
		String[] newArray = new String[newSize];
		for (String string : arr) {
			newArray[size++] = string;
		}
		arr = newArray;
	}

	public boolean isFull() {
		return size == arr.length;
	}

}
