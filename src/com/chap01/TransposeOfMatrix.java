package com.chap01;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class TransposeOfMatrix {

	public static void main(String[] args) {
		int[][] mat = ArrayGenerator.generate2DimensionalArray(4, 2);
		ArrayPrint.print2DimArray(mat);
		ArrayPrint.print2DimArray(getTranspose(mat));
	}
	
	public static int[][] getTranspose(int [][] mat){
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] tMat = new int[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tMat[j][i]=mat[i][j];
			}
		}
		return tMat;
	}
}
