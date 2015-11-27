package com.chap14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.util.In;
import com.util.StdOut;

public class ThreeSum {
	
	public static int count(int[] a){
		int n = a.length;
		int cnt =0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				for (int k = j+1; k < a.length; k++) {
					if(a[i]+a[j]+a[k] == 0){
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		int[] a = In.readInts("resources/8Kints.txt");
		StdOut.print(count(a));
				
	}
}
