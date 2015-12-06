package com.chap01.sec1_4;

import java.util.Arrays;

import com.util.ArrayGenerator;

public class P1412Print2sortedArray {
	
	public static void print2SortedArray(int[] a, int[] b){
		int a1,b1,acount=0,bcount=0;
		for (int i = 0; i < (a.length+b.length); i++) {
			a1=a[acount];
			b1=b[bcount];
			if((a1>=b1) || (acount==a.length)){
				System.out.print(b1+",");
				if(bcount<b.length-1)
				bcount++;
				continue;
			}else if((b1>=a1)||(bcount==b.length)){
				System.out.print(a1+",");
				if(acount<a.length-1)
				acount++;
				continue;
			}
		}
	}
	
	public static void print2SortedArrays1(int[] a, int[] b){
		int alength = a.length;
		int blength = b.length;
		
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(3);
		int[] b = ArrayGenerator.generateIntArray(3);
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		print2SortedArray(a, b);
	}
}
