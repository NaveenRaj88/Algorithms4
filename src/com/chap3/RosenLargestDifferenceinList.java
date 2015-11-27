package com.chap3;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;
import com.util.StdOut;

public class RosenLargestDifferenceinList {

	
	 public static void main(String[] args) {
		 RosenLargestDifferenceinList r = new RosenLargestDifferenceinList();
//		r.findLargestDifferenceInArray(ArrayGenerator.generateIntArray(10));
		r.findTheRepeatingElementsInArray(ArrayGenerator.generateAscendingIntArrayWithDuplicates(20));
		
	}
	 /*
	  * Describe an algorithm that takes as input a list of n integers
		and produces as output the largest difference obtained
		by subtracting an integer in the list from the one
		following it.
	  */
	 public void findLargestDifferenceInArray(int[] i){
		 
		 System.out.println(Arrays.toString(i));
		 int min = 0; //i[0]-i[1];
//		 System.out.println(min);
		 for (int j = 1; j < i.length; j++) {
			int temp = i[j]-i[j-1];
			if(temp < 0){
				temp=temp*-1;
			}
			if(temp>min){
				min=temp;
			}
		 }
		 System.out.println("largest difference is "+ min);
	 }
	 
	 /**
	  * Describe an algorithm that takes as input a list of n integers
		in nondecreasing order and produces the list of all
		values that occur more than once. (Recall that a list of
		integers is nondecreasing if each integer in the list is at
		least as large as the previous integer in the list.)
	  */
	 
	 public void findTheRepeatingElementsInArray(int[] i){
		 ArrayPrint.printArray(i);
		 int[] repeatedArray = new int[i.length];
		 int counter = 0;
		 for (int j = 0; j < i.length; j++) {
			for (int j2 = j+1; j2 < i.length; j2++) {
				if(i[j]==i[j2]){
					repeatedArray[counter++]=i[j];
				}else
					break;
				j=j2;
			}
		}
		 ArrayPrint.printArray(repeatedArray);
	 }
}
