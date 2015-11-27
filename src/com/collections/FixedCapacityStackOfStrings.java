package com.collections;

public class FixedCapacityStackOfStrings {

	private String[] a;
	private int n;
	
	public FixedCapacityStackOfStrings(int cap) {
		a=new String[cap];
	}
	
	public boolean isEmpty(){
		return n==0;
	}
	
	public int size(){
		return n;
	}
	
	public void push(String item){
		a[n++]=item;
	}
	
	public String pop(){
		return a[--n];
	}
	
	public static void main(String[] args) {
		String inp="to be or not to - be - - that - - - is";
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
		for (String item : inp.split(" ")) {
			if(!item.equals("-")){
				s.push(item);
			}
			else if (!s.isEmpty()) 
				System.out.println(s.pop() + " ");
		}
		
		System.out.println("(" + s.size() + " left on stack)");
	}
}
