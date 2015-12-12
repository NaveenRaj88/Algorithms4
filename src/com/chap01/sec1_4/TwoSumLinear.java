package com.chap01.sec1_4;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

/**
 * As a warmup, develop an implementation TwoSumFaster that
uses a linear algorithm to count the pairs that sum to zero after the array is sorted (instead
of the binary-search-based linearithmic algorithm)
 * @author Naveen kumar
 *
 */
public class TwoSumLinear {

	public static void printSumZero(int[] a){
		int indexi=0, indexj=a.length-1;
		int count=0;
		while(indexi!=indexj){
			int i=a[indexi],j=a[indexj];
			if(i+j ==0){
				count++;
				indexi++;
			}else if(i<0){
				if(j<0){
					indexi++;
				}else{
					indexj--;
				}
			}else if(i<j){
				indexj--;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		int [] a = ArrayGenerator.generateIntArrayWithNegatives(10);
		ArrayPrint.printArray(a);
		printSumZero(new int[]{-4, -4, -3, -2, 0, 2, 3, 4, 4, 4});
	}
}
