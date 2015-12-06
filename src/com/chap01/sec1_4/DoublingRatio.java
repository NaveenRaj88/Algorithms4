package com.chap01.sec1_4;

import com.util.StdOut;
import com.util.StdRandom;
import com.util.Stopwatch;

public class DoublingRatio {

	public static double timeTrial(int N) { // Time ThreeSum.count() for N
		// random 6-digit ints.
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		double prev = timeTrial(125);
		for (int n=250; true; n+=n) {
			double time  = timeTrial(n);
			StdOut.printf("%6d %7.1f ", n, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time;
		}
	}
}
