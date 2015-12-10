package com.chap01.sec1_4;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class BinarySearchSmallestIndex {
	
	private static void search(int[] a, int high, int low, int find){
		int mid = (high+low)/2;
		if(a[mid] == find){
			while(mid>0  && a[--mid] == find);
			System.out.println(++mid);
			return;
		}
		else if(a[mid] > find){
			search(a, mid, low, find);
		}else{
			search(a, high, mid, find);
		}
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArrayWithDuplicates(10);
		Arrays.sort(a);
		ArrayPrint.printArray(a);
		search(a, a.length-1, 0, a[3]);
	}
}
