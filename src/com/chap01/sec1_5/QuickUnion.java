package com.chap01.sec1_5;

import com.util.In;

public class QuickUnion extends UF {

	public QuickUnion(int n) {
		super(n);
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot){
			return;
		}
		id[pRoot] = qRoot;
		count--;
	}

	@Override
	public int find(int p) {
		while(p != id[p]){
			p=id[p];
		}
		return p;
	}

	public static void main(String[] args) {
		int[] a = In.readInts("resources/tinyUf.txt");
		int index = 0;
		QuickUnion qu = new QuickUnion(a[index++]);
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
