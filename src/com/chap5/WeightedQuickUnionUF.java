package com.chap5;

import com.util.In;
import com.util.StdOut;

public class WeightedQuickUnionUF extends UF{

	private int[] sz;
	
	public WeightedQuickUnionUF(int n) {
		super(n);
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			sz[i]=1;
		}
	}

	@Override
	int find(int p) {
		while(p!= id[p])
			p=id[p];
			return p;
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		// Make smaller root point to larger one.
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] =i;
			sz[i] += sz[j];
		}
		count--;
	}
	
	public static void main(String[] args) {
		String filename = "resources/mediumUF.txt";
		In in = new In(filename);
		int n = in.readInt();
		UF uf = new WeightedQuickUnionUF(n);
		
		while(!in.isEmpty()){
			int p = in.readInt();
			int q = in.readInt();
			if(uf.connected(p, q)){
				continue;
			}
			uf.union(p, q);
			StdOut.print("("+p+","+q+")");
		}
		StdOut.print(uf.count()+" components");
	}
	
}
