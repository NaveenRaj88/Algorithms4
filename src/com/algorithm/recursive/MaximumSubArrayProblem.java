package com.algorithm.recursive;

import com.util.ArrayGenerator;
import com.util.ArrayPrint;


public class MaximumSubArrayProblem {
	
	private Tuple findMaxCrossingSubarray(int [] i, int low, int mid, int high){
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid;
		for (int j = mid; j >=low ; j--) {
			sum = sum +i[j];
			if(sum > leftSum){
				leftSum =sum;
				maxLeft = j;
			}
		}
			int rightSum = Integer.MIN_VALUE;
			int maxRight = mid+1;
			for (int k = mid+1; k <= high; k++) {
				sum=sum+i[k];
				if(sum>rightSum){
					rightSum = sum;
					maxRight = k;
				}
			}
			
		return new Tuple(maxLeft, maxRight, (i[maxLeft]+i[maxRight]));
	}
	
	public Tuple findMaxSubarray(int[] i, int low, int high){
		Tuple leftTuple,rightTuple,crossTuple;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		if(low == high){
			return new Tuple(low, high, i[low]);
		}
 		else {
 			int mid = (low+high/2);
		leftTuple=findMaxSubarray(i, low, mid);
		rightTuple = findMaxSubarray(i, mid+1, high);
		crossTuple = findMaxCrossingSubarray(i, low, mid, high);
 		}
		if(leftTuple.sum >= rightTuple.sum && leftTuple.sum >= crossTuple.sum){
			return leftTuple;
		}
		else if(rightTuple.sum >=leftTuple.sum && rightTuple.sum >= crossTuple.sum){
			return rightTuple;
		}
		else return crossTuple;
		
	}
	
	class Tuple {
		int maxLeft;
		int maxRight;
		int sum;
		public Tuple(int maxLeft, int maxRight, int sum) {
			super();
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) {
		int[] i = ArrayGenerator.generatePosAndNegArray(10);
		ArrayPrint.printArray(i);
		Tuple tuple = new MaximumSubArrayProblem().findMaxSubarray(i, 0, i.length-1
				);
		System.out.println(tuple.maxLeft +"  " +tuple.maxRight+"  "+ tuple.sum);
		
	}
	
}
