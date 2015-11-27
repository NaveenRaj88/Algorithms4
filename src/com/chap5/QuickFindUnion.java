package com.chap5;

import com.util.In;
import com.util.StdOut;

public class QuickFindUnion extends UF{

	QuickFindUnion(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int find(int p) {
		return id[p];
	}
	

	@Override
	public void union(int p, int q) {
		// Put p and q into the same component.
		int pId = find(p);
		int qId = find(q);
		// Nothing to do if p and q are already in the same component.
		if(pId ==qId){
			return;
		}
		
		// Rename p’s component to q’s name.
		for (int i = 0; i < id.length; i++) {
			if(id[i] == pId){
				id[i] = qId;
			}
			
		}
		count--;
	}
	
	public static void main(String[] args) {
		String filename = "resources/mediumUF.txt";
		In in = new In(filename);
		int n = in.readInt();
		UF uf = new QuickFindUnion(n);
		
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
