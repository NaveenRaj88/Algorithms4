package com.chap01.sec1_4;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class P1416ClosestPair1Dimension {

	public static void closestPairQuadratic(double[] d){
		int n = d.length;
		double min = d[0]-d[1];
		double temp;
		int di = 0,dj = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = i+1; j < d.length; j++) {
				temp = d[j]-d[i];
				if(temp< min){
					min=temp;
				di = i;
				dj=j;
				}
			}
		}
		System.out.println("closest pairs = "+d[di] +" & "+d[dj]);
	}
	
	public static void closestPairLinearithmic(double[] d){
		
	}
	
	public static void main(String[] args) {
		double[] d = ArrayGenerator.generateDoubleArray(10);
		ArrayPrint.printArray(d);
		closestPairQuadratic(d);
	}
}
