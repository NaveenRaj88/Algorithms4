package com.baseexpansion;

import java.util.ArrayList;
import java.util.List;

public class BinaryMultiplication {

	public void mulBinary(int a, int b){
		BinaryAddition binaryAddition = new BinaryAddition();
		List<Integer> product = new ArrayList<Integer>();
		List<Integer> listb = new ArrayList<Integer>();
		binaryAddition.createIntegerList(b, listb);
		int finalProduct = 0;
//		Collections.reverse(listb);
		for (int i = 0; i <listb.size(); i++) {
			if(listb.get(i) == 1){
				//product.add((int) (a*Math.pow(10, i)));
				finalProduct = binaryAddition.getOneInteger(binaryAddition.addBinary(finalProduct, (int) (a*Math.pow(10, i))));
			}
		}
		System.out.println("final product "+ finalProduct);
	}
	
	public static void main(String[] args) {
		new BinaryMultiplication().mulBinary(110, 101);
	}
}
