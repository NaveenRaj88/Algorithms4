package com.chap01.sec1_5;

import com.util.In;

public class WeightedQuickUnion extends UF {

	private int[] sz;

	public WeightedQuickUnion(int n) {
		super(n);
		sz = new int[n];
		for (int i = 0; i < id.length; i++) {
			sz[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}

		// Make smaller root point to larger root
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public static void main(String[] args) {
		int[] a = In.readInts("resources/tinyUf.txt");
		int index = 0;
		WeightedQuickUnion qu = new WeightedQuickUnion(a[index++]);
		while (index < a.length) {
			int p = a[index++];
			int q = a[index++];
			if (qu.connected(p, q)) {
				continue;
			}
			qu.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(qu.count + " components");
	}
}
