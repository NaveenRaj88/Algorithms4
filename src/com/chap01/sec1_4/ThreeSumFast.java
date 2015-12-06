package com.chap01.sec1_4;

import java.util.Arrays;

import com.chap01.BinarySearchRec;
import com.util.In;
import com.util.StdOut;

public class ThreeSumFast {

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
		int[] a = In.readInts("resources/32Kints.txt");
		StdOut.println(count(a));
	}

}
