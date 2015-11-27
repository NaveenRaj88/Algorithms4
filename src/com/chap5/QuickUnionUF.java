package com.chap5;

import com.util.In;
import com.util.StdOut;

public class QuickUnionUF extends UF{

	public QuickUnionUF(int n) {
		super(n);
	}

	@Override
	int find(int p) {
		while(p != id[p])
			p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		if(proot == qroot){
			return;
		}
		id[proot] = qroot;
		count--;
	}

	public static void main(String[] args) {
		String filename = "resources/mediumUF.txt";
		In in = new In(filename);
		int n = in.readInt();
		UF uf = new QuickUnionUF(n);
		
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
