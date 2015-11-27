package com.test;

public class ClassA {
	
	@Autowired
	private ClassBInteface  classb;
	
	public void callB(){
		classb.dosomethingB();
	}
	
	public static void main(String[] args) {
		
	}
}
