package com.chap01.sec1_5;

import com.util.In;
import com.util.StdIn;

public class QuickFind extends UF {

	public QuickFind(int n) {
		super(n);
	}

	@Override
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId)
			return;
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
		count--;
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	public static void main(String[] args) {
		int[] a = new In("resources/mediumUf.txt").readAllInts();
		int index = 0;
		QuickFind qf = new QuickFind(a[index++]);
		while (index < a.length) {
			int p = a[index++];
			int q = a[index++];
			if (qf.connected(p, q)) {
				continue;
			}
			qf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(qf.count + " components");
	}
}
