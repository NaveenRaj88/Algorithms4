package com.chap01;

import com.util.ArrayPrint;

public class Boolean2DArrayPrimality {
	
	public static void main(String[] args) {
		boolean [][] bool = new boolean[10][5];
		for (int i = 0; i < bool.length; i++) {
			for (int j = 0; j < bool[0].length; j++) {
				if(EuclidAlgo.getGcd(i, j) ==1 ){
					bool[i][j]= true;
				}
			}
		}
		ArrayPrint.print2DimArray(bool);
	}
}
