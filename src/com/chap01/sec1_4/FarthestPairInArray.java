package com.chap01.sec1_4;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

/**
 * Farthest pair (in one dimension). Write a program that, given an array a[] of
 * N double values, finds a farthest pair : two values whose difference is no
 * smaller than the the difference of any other pair (in absolute value). The
 * running time of your program should be linear in the worst case.
 * 
 * @author Naveen kumar
 *
 */
public class FarthestPairInArray {
	public static void printFarthestPair(int[] a) {
		int lowest = a[0], highest = a[1];
		for (int i = 2; i < a.length; i++) {
			int val = a[i];
			if (val < lowest) {
				lowest = val;
			} else if (val > highest) {
				highest = val;
			}
		}
		int farthestDistance = highest - lowest;
		// the complexity N
		ArrayPrint.printArray(a);
		System.out.println("farthest pairs in array is " + lowest + " and " + highest + " farthestDistance is "
				+ farthestDistance);
	}

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(10);
		printFarthestPair(a);

	}
}
