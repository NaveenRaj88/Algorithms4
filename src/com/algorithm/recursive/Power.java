package com.algorithm.recursive;

public class Power {
	
	public int getPower(int base, int exponent){
		if(base == 0){
			System.out.println("base should be a nonzero integer");
		}
		// since base power 0 is 1.
		if(exponent == 0){
			return 1;
		}
		return base*getPower(base, exponent-1);
	}
	
	public static void main(String[] args) {
		Power p = new Power();
		System.out.println(p.getPower(2, 8));
	}
}
