package com.chap01.sec1_5;

public abstract class UF {

	protected int id[];
	protected int count;

	// initialize N sites with integer names (0 to N-1)
	public UF(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	// number of components
	public int count() {
		return count;
	}

	// add connection between p and q
	public abstract void union(int p, int q);

	// component identifier for p (0 to N-1)
	public abstract int find(int p);

	// return true if p and q are in the same component
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	

}
