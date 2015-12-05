package com.sort;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class InsertionSort {

	public static int[] sortIncreasing(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
	
	public static int[] sortDecreasing(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr = ArrayGenerator.generateIntArray(10);
		ArrayPrint.printArray(arr);
		ArrayPrint.printArray(sortIncreasing(arr));
		ArrayPrint.printArray(sortDecreasing(arr));
		
	}
}
