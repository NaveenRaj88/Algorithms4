package com.chap14;

import java.util.Arrays;

import com.chap01.BinarySearchRec;
import com.util.In;
import com.util.StdOut;

public class TwoSumFast {
	
	public static int count(int[] a){
		int n = a.length;
		int cnt = 0;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			if(BinarySearchRec.rank(-a[i],a) > i){
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts("resources/1Mints.txt");
		StdOut.print(count(a));
	}
}
