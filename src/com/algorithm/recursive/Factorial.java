package com.algorithm.recursive;

public class Factorial {

	public int factorial(int n) {
		// since 0! or 1! is 1
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorial(10));

	}

}
