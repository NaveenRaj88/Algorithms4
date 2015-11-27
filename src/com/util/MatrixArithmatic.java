package com.util;

public class MatrixArithmatic {

	public static void main(String[] args) {
		double[][] a = new double[][]{{1,-1,2},{0,-3,1}};
		double[][] b = new double[][]{{2},{1},{0}};
		ArrayPrint.print2DimArray(mult(a, b));
	}

	public static double dot(double[] x, double[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("vector sies are not equal ");
		}
		double sum = 0;
		for (int i = 0; i < y.length; i++) {
			sum = sum + x[i] * y[i];
		}
		return sum;
	}

	public static double[][] mult(double[][] a, double[][] b) {
		if (a[0].length != b.length) {
			throw new IllegalArgumentException("matrix size does not match");
		}
		double[][] matMul = new double[a.length][b[0].length];
		for (int k = 0; k < matMul.length; k++) {
			for (int i = 0; i < a[0].length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					matMul[k][j]= matMul[k][j]+a[j][i]*b[i][j];
				}
			}
		}
		return matMul;
	}

//	public static double[][] transpose(double[][] a) {
//
//	}
//
//	static double[] mult(double[][] a, double[] x) {
//
//	}
//
//	static double[] mult(double[] y, double[][] a) {
//
//	}
}
