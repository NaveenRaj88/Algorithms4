package com.chap01.sec1_2;

import com.util.In;

public class Shell extends AbstractSort {

	public void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h],
											// a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}
	
	public static void main(String[] args) {
		String fileName = "resources/words3.txt";
		In in = new In(fileName);
		Comparable[] s = in.readAllStrings();
		new InsertionSort().sort(s);
		assert isSorted(s);
		show(s);
	}
}
