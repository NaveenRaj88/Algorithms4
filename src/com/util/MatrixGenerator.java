package com.util;

import java.util.Random;

public class MatrixGenerator {
	
	private static Random random = new Random();
	
	public static int[][] generateIntSquareMatrix(int size){
		int[][] squareMatrix = new int[size][size];
		for (int i = 0; i < squareMatrix.length; i++) {
			for (int j = 0; j < squareMatrix.length; j++) {
				squareMatrix[i][j] = random.nextInt(9);
			}
		}
		return squareMatrix;
	}
	
}
