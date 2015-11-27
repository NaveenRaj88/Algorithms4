package com.algorithm.recursive;

import java.util.Arrays;

import com.util.ArrayGenerator;

public class MaxSubrrayProb {

	public Tuple findMaxCrossSubarray(int[] i, int low, int mid, int high){
		int leftSum = Integer.MIN_VALUE;
		int sum =0;
		Tuple t = new Tuple();
		for(int j=mid;j>low; j-- ){
			sum = sum + i[j];
			if(sum > leftSum){
				leftSum =sum;
				t.maxLeft=j;
			}
		}
		int rightSum=Integer.MIN_VALUE;
		for(int j = mid+1; j<=high; j++){
			sum = sum + i[j];
			if(sum>rightSum){
				rightSum = sum;
				t.maxRight= j;
			}
		}
		t.sum = leftSum+rightSum; 
		return t;
	}
	
	public Tuple findMaxSubarray(int[] i, int low, int high){
		if(low == high){
			return new Tuple(low, high, i[low]);
		}
		int mid = (low+high)/2;
		Tuple leftTuple = findMaxSubarray(i, low, mid);
		Tuple rightTuple = findMaxSubarray(i, mid+1, high);
		Tuple crossTuple = findMaxCrossSubarray(i, low, mid, high);
		if(leftTuple.sum>rightTuple.sum  && leftTuple.sum > crossTuple.sum){
			return leftTuple;
		}
		else if(rightTuple.sum > leftTuple.sum && rightTuple.sum > crossTuple.sum ){
			return rightTuple;
		}
		else{
			return crossTuple;
		}
	}
	
	public static void main(String[] args) {
		int[] i = ArrayGenerator.generatePosAndNegArray(10);
		System.out.println(Arrays.toString(i));
		Tuple t = new MaxSubrrayProb().findMaxSubarray(i, 0, i.length-1);
		System.out.println(t.maxLeft+"  "+t.maxRight+"  "+t.sum);
	}
	
	class Tuple{
		public int maxLeft;
		public int maxRight;
		public int sum;
		 public Tuple() {
			// TODO Auto-generated constructor stub
		}
		public Tuple(int maxLeft, int maxRight, int sum) {
			super();
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}
	}
}
