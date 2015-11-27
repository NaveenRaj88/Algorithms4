package com.chap5;

public  abstract class UF {

	protected int[] id;
	protected int count;
	
	public UF(int n){
		//initialize N sites with integer names (0 to N-1)
		
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	 abstract int find(int p);
	
	public abstract void union(int p, int q);
	
	
	
//	abstract void union(int p, int q); //add connection between p and q
//	abstract int find(int p) ; //component identifier for p (0 to N-1)
//	abstract boolean connected(int p, int q); //return true if p and q are in the same component
//	abstract int count();  // number of
	
}
