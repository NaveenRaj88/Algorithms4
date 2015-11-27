package com.sort;

import java.util.LinkedList;

public class MainClass {

	public void waiting(){
		try {
			this.wait(500000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("starting main method");
		MainClass m = new MainClass();
		m.waiting();
	}
}
