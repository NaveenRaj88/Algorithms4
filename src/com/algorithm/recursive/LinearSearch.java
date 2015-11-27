package com.algorithm.recursive;

import java.util.Random;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;

public class LinearSearch {
	int loopInvariant = 0;

	public String search(int i[], int j) {
		if(loopInvariant == i.length-1){
			return "the number does not exist";
		}
		if(i[loopInvariant] == j){
			return "the number " + j + " exist at " + loopInvariant + " position in the array";
		}
		else{
			loopInvariant++;
			return search(i, j);
		}
			
//		if (j == i[loopInvariant]) {
//			return "the number " + j + " exist at " + loopInvariant + " position";
//		} else if (loopInvariant < i.length) {
//			loopInvariant++;
//			search(i, j);
//			return;
//		}
////		else {
//			return "the number does not exist";
////		}
		
	}

	public static void main(String[] args) {
		LinearSearch linearSearch = new LinearSearch();
		int[] i = ArrayGenerator.generateIntArray(10);
		ArrayPrint.printArray(i);
		int j = i[new Random().nextInt(9)];
//		j=i[2];
		System.out.println("Searching for " + j);
		System.out.println(linearSearch.search(i, j));
	}
	
}
