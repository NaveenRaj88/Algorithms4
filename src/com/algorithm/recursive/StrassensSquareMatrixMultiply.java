package com.algorithm.recursive;

import com.util.MatrixGenerator;
import com.util.MatrixPrinter;

public class StrassensSquareMatrixMultiply {

	public static void multiply(int[][] a, int [][] b){
		int rows = a.length;
		int[][] c = new int[rows][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < rows; k++) {
					c[i][j] = c[i][j]+a[i][k]*b[k][j];
				}
			}
		}
		MatrixPrinter.printIntMatrix(a);
		System.out.println();
		MatrixPrinter.printIntMatrix(b);
		System.out.println();
		MatrixPrinter.printIntMatrix(c);
	}
	
	public static void main(String[] args) {
		multiply(MatrixGenerator.generateIntSquareMatrix(2), MatrixGenerator.generateIntSquareMatrix(2));
	}
}
