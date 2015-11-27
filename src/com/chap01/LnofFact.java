package com.chap01;

public class LnofFact {

	public static int getLn(int n){
		double e = 2.71;
		int temp=0;
		double exp = e;
		while(true){
			if(exp >= n){
				return temp;
			}
				exp=exp*e;
				temp=temp+1;
		}
	}

	public static int fact(int n) {

		if (n == 0)
			return 1;
		return n * fact(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getLn(fact(10)));
	}
}
