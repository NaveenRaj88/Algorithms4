package com.chap01.sec1_4;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

/**
 * Write a program that, given two sorted arrays of N int values, prints all
 * elements that appear in both arrays, in sorted order. The running time of
 * your program should be proportional to N in the worst case.
 * 
 * @author Naveen kumar
 *
 */
public class CommonElemInArrays {

	public static void printCommon(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				System.out.println(a[i]);
				i++;
			} else {
				if (a[i] > b[j]) {
					j++;
				} else {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateAscendingIntArray(10);
		int[] b = ArrayGenerator.generateAscendingIntArray(10);
		ArrayPrint.printArray(a);
		ArrayPrint.printArray(b);
		printCommon(a, b);
	}
}
