package com.chap14;

import java.util.Arrays;

import com.util.ArrayGenerator;

public class P148PairsInArray {
	
	public static int MySolutionQuadratic(int[] a){
		int n = a.length;
		int cnt =0;
		if(a.length<1){
			return 0;
		}
		for (int i = 0; i <n; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i] == a[j]){
					cnt++;
				break;
				}
			}
		}
		return cnt;
	}
	
	public static int bookSolutionSort(int[] a){
		int n = a.length;
		int cnt =0;
		Arrays.sort(a);
		for (int i = 0; i < n-1; i++) {
			if(a[i]==a[i+1])
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(10,5);
		System.out.println(Arrays.toString(a));
		System.out.println("number of pairs = "+MySolutionQuadratic(a));
		System.out.println("number of pairs sorted= "+bookSolutionSort(a) );
	}
}
