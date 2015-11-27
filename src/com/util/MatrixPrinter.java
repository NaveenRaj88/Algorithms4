package com.util;

public class MatrixPrinter {

	public static void printIntMatrix(int[][] matrix) {
//		int rows=matrix.length;
//		int columns = matrix[0].length;
		
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
