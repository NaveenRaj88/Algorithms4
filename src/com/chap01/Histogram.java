package com.chap01;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class Histogram {

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(7);
		ArrayPrint.printArray(a);
		ArrayPrint.printArray(histogram(a, 2));
	}

	public static int[] histogram(int[] a, int bins) {
		int[] hist = new int[bins];
		Arrays.sort(a);
		int maxElem = a[a.length - 1];
		int minElem = a[0];
		int binRange = (int) Math.ceil(((double)(maxElem - minElem))/ bins);
		int binMax = a[0] + binRange;
		int histIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= binMax) {
				hist[histIndex] = hist[histIndex] + 1;
			} else {
				binMax= binMax+binRange;
				histIndex++;
				i--;
			}
		}
		return hist;
	}

}
