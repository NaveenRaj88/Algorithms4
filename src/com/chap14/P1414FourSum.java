package com.chap14;

import com.util.In;
import com.util.StdIn;

public class P1414FourSum {
	
	public static int fourSum(int[] a){
		int n = a.length;
		int count = 0; 
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < a.length; j++) {
				for (int j2 = j+1; j2 < a.length; j2++) {
					for (int k = j2+1; k < a.length; k++) {
						if(a[i]+a[j]+a[j2]+a[k]==0)
							count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String fileName = "resources/1Kints.txt";
		int[] a = new In(fileName).readAllInts();
		System.out.println(fourSum(a));
	}
}
