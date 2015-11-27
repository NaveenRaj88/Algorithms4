package com.util;

import java.util.Arrays;

public class ArrayPrint {

	public static void printArray(int[]... a) {
		for (int[] is : a) {
			System.out.println(Arrays.toString(is));
		}
	}

	public static void printArray(double[]... a) {
		for (double[] is : a) {
			System.out.println(Arrays.toString(is));
		}
	}

	public static <T> void printArray(T[] obj) {
		for (int i = 0; i < obj.length; i++) {
			System.out.print(obj[i]);
		}
	}

	public static void print2DimArray(int[][] a) {
		System.out.println("***********");
		for (int[] is : a) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("***********");
	}
	
	public static void print2DimArray(double[][] a) {
		System.out.println("***********");
		for (double[] is : a) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("***********");
	}
	
	public static void print2DimArray(boolean[][] a) {
		System.out.println("***********");
		for (boolean[] is : a) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("***********");
	}

	public static <T> void print2DArray(T[][] obj) {
		System.out.println("***********");
		for (int i = 0; i < obj.length; i++) {
			ArrayPrint.printArray(obj[i]);
		}
		System.out.println("***********");
	}
}
