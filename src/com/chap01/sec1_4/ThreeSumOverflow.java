package com.chap01.sec1_4;

import java.util.Arrays;

import com.chap01.BinarySearchRec;
import com.util.In;
import com.util.StdOut;

public class ThreeSumOverflow {

	public static int count(int[] a) { // Count triples that sum to 0.
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				if (BinarySearchRec.rank(-a[i] - a[j], a) > j)
					cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		int[] a = In.readInts("resources/1Mints.txt");
		StdOut.println(count(a));
	}

	private static int safeAdd(int i, int j) {
		if (i > 0 ? j > Integer.MAX_VALUE - i : j < Integer.MIN_VALUE - i) {
			throw new ArithmeticException("Integer Overflow");
		}
		return i + j;
	}

	private static int safeSubtract(int i, int j) {
		if (j > 0 ? i < Integer.MIN_VALUE + j : i > Integer.MAX_VALUE + j) {
			throw new ArithmeticException("Integer Overflow");
		}
		return i - j;
	}

	static final int safeMultiply(int left, int right) throws ArithmeticException {
		if (right > 0 ? left > Integer.MAX_VALUE / right || left < Integer.MIN_VALUE / right
				: (right < -1 ? left > Integer.MIN_VALUE / right || left < Integer.MAX_VALUE / right
						: right == -1 && left == Integer.MIN_VALUE)) {
			throw new ArithmeticException("Integer overflow");
		}
		return left * right;
	}

	static final int safeDivide(int left, int right) throws ArithmeticException {
		if ((left == Integer.MIN_VALUE) && (right == -1)) {
			throw new ArithmeticException("Integer overflow");
		}
		return left / right;
	}

	static final int safeNegate(int a) throws ArithmeticException {
		if (a == Integer.MIN_VALUE) {
			throw new ArithmeticException("Integer overflow");
		}
		return -a;
	}

	static final int safeAbs(int a) throws ArithmeticException {
		if (a == Integer.MIN_VALUE) {
			throw new ArithmeticException("Integer overflow");
		}
		return Math.abs(a);
	}
}
