package com.chap14;

import com.util.In;
import com.util.StdOut;

public class TwoSum {

	public static int count(int[] a){
		int n = a.length;
		int cnt =0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(a[i]+a[j] == 0){
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts("resources/1Mints.txt");
		StdOut.print(count(a));
	}
}
