package com.util;

public class HighestElementinArray {

	
	public static int getHighestElementinArray(int[] a){
		int max=0;
		for (int i : a) {
			if(i>max){
				max=i;
			}
		}
		return max;
	}
	
}
