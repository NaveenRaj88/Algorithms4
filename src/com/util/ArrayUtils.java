package com.util;

import java.util.Random;

import com.chap01.Node;

public class ArrayUtils {

	private static Random random = new Random();

	public static <T> void randomize(T[] arr) {
		int size = arr.length;
		for (int i = 0; i < arr.length; i++) {
			int dest = random.nextInt(size);
			T temp = arr[dest];
			arr[dest] = arr[i];
			arr[i] = temp;
		}
	}

	private static <T> T[] copyArray(Node<T> node, int size) {
		T[] array = (T[]) new Object[size];
		int counter = 0;
		while (node != null) {
			array[counter++] = node.value;
		}
		return array;
	}
}
