package com.chap01;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class BinarySearchRec {

	public static int bSearchRec(int a[], int hi, int lo, int find, int recDepth) {
		System.out.println("hi=" + hi + " lo=" + lo + " depth=" + recDepth++);
		int mid = (int) Math.ceil((double) (hi + lo) / 2);
		if (a[mid] == find) {
			return mid;
		}
		if (hi == lo) {
			return -1;
		}
		if (a[mid] > find) {
			return bSearchRec(a, mid - 1, lo, find, recDepth);
		} else {
			return bSearchRec(a, hi, mid + 1, find, recDepth);
		}
	}

	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}

	public static int rank(int key, int[] a, int lo, int hi) {
		// Index of key in a[], if present, is not smaller than lo and not
		// larger than hi.
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid])
			return rank(key, a, lo, mid - 1);
		else if (key > a[mid])
			return rank(key, a, mid + 1, hi);
		else
			return mid;
	}

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateAscendingIntArray(10);
		ArrayPrint.printArray(a);
		System.out.println(bSearchRec(a, a.length - 1, 0, a[7], 0));
	}

}
