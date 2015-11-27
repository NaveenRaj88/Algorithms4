package com.chap01;

public class EuclidAlgo {

	public static int getGcd(int a, int b){
		if(a==0 || b==0){
			return 0;
		}
		if(b> a){
			int temp = a;
			a=b;
			b=temp;
		}
		
		int remainder = a%b;
		if(remainder == 0 ){
			return b;
		}
		return getGcd(b, remainder);
	}
	
	public static void main(String[] args) {
		System.out.println(getGcd(1071, 462));
		System.out.println(getGcd(1234567,1111111));
	}
}
