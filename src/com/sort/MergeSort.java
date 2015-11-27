package com.sort;

import java.util.Arrays;

import com.util.ArrayGenerator;

public class MergeSort {
	
	 public static void merge(int[] i, int p, int q, int r){
		 int[] lArr = new int[q-p];
		 int[] rArr = new int[r-q];
		 for (int j = 0; j <=q; j++) {
			lArr[j]=i[p];
			p++;
		}
		 for (int k = 0; k <=r ; k++) {
			 q++
			rArr[k] = i[q]
		}
		while (ls <= le && rs <= re){
			if(){
				
			}
		}
		 
		 
	}
	
	public static void main(String[] args) {
		int [] a = ArrayGenerator.generateIntArray(10000);
		System.out.println(Arrays.toString(a));
		msp.mergeSort(a, 0, a.length);
		System.out.println(Arrays.toString(a));
	}
}
