package com.chap01;

import com.util.In;

public class ReadInts {

	public static int[] readInts(String name){
		In in = new In(name);
		Queue<Integer> q = new Queue<>();
		while(!in.isEmpty()){
			q.enqueue(in.readInt());
		}
		int[] a = new int[q.size()];
		int index=0;
		for (Integer integer : q) {
			a[index++] = integer;
		}
		return a;
	}
}
