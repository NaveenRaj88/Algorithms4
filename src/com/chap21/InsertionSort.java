package com.chap21;

import com.util.ArrayGenerator;
import com.util.In;

public class InsertionSort extends AbstractSort {

	@Override
	public void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		int n = a.length;
		int j = 0;
		@SuppressWarnings("rawtypes")
		Comparable temp;
		for (int i = 1; i < n; i++) {
			j=i-1;
			 temp = a[i];
			while(j>=0 && less(temp,a[j])){
				a[j+1] = a[j];
				j=j-1;
			}
			a[j+1]=temp;
		}
		
	}

	public static void main(String[] args) {
		  String fileName = "resources/words3.txt";
	         In in = new In(fileName);
	         Comparable[] s= in.readAllStrings();
	         new InsertionSort().sort(s);
	         assert isSorted(s);
	         show(s);
//		Integer[] a = ArrayGenerator.wrapperIntArray(3);
//		show(a);
//		new InsertionSort().sort(a);
//		show(a);
		
		
	}
}
