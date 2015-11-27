package com.baseexpansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBExpansion {

	public void printBaseBExpansion(int n, int b){
		int q=n;
		List list = new ArrayList();
		while(q != 0){
			list.add(q % b);
			q = q/b;
		}
		Collections.reverse(list);
		System.out.println(list);
		System.out.println(Integer.parseInt("1010", 2));
		System.out.println(Integer.reverse(1));
	
	}
	public static void main(String[] args) {
		new BaseBExpansion().printBaseBExpansion(10, 2);
	}
}
