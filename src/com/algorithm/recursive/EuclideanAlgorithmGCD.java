package com.algorithm.recursive;

public class EuclideanAlgorithmGCD {

	public int getGCD(int a, int b){
		if(b>a){
			int temp = b;
			b=a;
			a=temp;
		}
		if(a % b ==0){
			return b;
		}
		return getGCD(b, a%b);
	}
	
	public static void main(String[] args) {
		EuclideanAlgorithmGCD eGcd = new EuclideanAlgorithmGCD();
		System.out.println(eGcd.getGCD(5, 8));
	}
}
