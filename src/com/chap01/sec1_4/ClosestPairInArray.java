package com.chap01.sec1_4;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

/**
 * Closest pair (in one dimension). Write a program that, given an array a[] of
 * N double values, finds a closest pair : two values whose difference is no
 * greater than the the difference of any other pair (in absolute value). The
 * running time of your program should be linearithmic in the worst case.
 * 
 * @author Naveen kumar
 *
 */
public class ClosestPairInArray {

	public static void printClosestPair(int[] a) {
		Arrays.sort(a); // takes NlogN complexity for sorting
		int indexi = 0, indexj = 0, closestDistance = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int currentDistance = Math.abs(Math.abs(a[i]) - Math.abs(a[i + 1]));
			if (currentDistance < closestDistance) {
				indexi = i;
				indexj = i + 1;
				closestDistance = currentDistance;
			}
		}

		// the complexity is NLogN + N if you ignore the lower order terms then
		// it is NlogN
		ArrayPrint.printArray(a);
		System.out.println("closes pairs in array is " + a[indexi] + " and " + a[indexj] + " closestDistance is "
				+ closestDistance);
	}

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(10);
		printClosestPair(a);

	}
}
