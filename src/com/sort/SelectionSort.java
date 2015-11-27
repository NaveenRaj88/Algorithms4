package com.sort;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class SelectionSort {

	public static int[] selectionSorter(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = a[smallestIndex];
			a[smallestIndex] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static int[] selectionSorterReverse(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = a[smallestIndex];
			a[smallestIndex] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] i = ArrayGenerator.generateIntArray(10);
		ArrayPrint.printArray(i);
		ArrayPrint.printArray(selectionSorter(i));
		ArrayPrint.printArray(selectionSorterReverse(i));
		
	}
}
