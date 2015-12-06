package com.search;

import java.util.Arrays;

import com.sort.InsertionSort;
import com.util.ArrayGenerator;

public class BinarySearch {

	public static void binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length-1;
		int median = a.length/2;
		while(true){
		if(key<a[median]){
			end = median;
			median = (end + start) /2;
		}else if(key>a[median]){
			start = median;
			median = (end+start)/2;
		}
		else
			break;
		}
		System.out.println(median +"  "+ a[7]);
	}

	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateIntArray(10);
		System.out.println(Arrays.toString(a)+a[7]);
		binarySearch(a , a[7]);
	}
}
