package com.chap01.sec1_4;

import com.chap01.ReadInts;
import com.util.ArrayGenerator;
import com.util.In;

public class FourSum {

	public static void printFoursum(int[] a){
		int cnt=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				for (int k = j+1; k < a.length; k++) {
					for (int l = k+1; l < a.length; l++) {
						if(a[i]+a[j]+a[k]+a[l] == 0){
							System.out.println(" "+a[i]+a[j]+a[k]+a[l]);
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts("resources/1Kints.txt");
		a=ArrayGenerator.generateIntArray(80);
		printFoursum(a);
	}
}
