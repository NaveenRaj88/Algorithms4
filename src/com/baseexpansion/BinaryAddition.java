package com.baseexpansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryAddition {

	
	public List<Integer> addBinary(int a, int b){
		List<Integer> lista = new ArrayList<Integer>();
		List<Integer> listb = new ArrayList<Integer>();
		List<Integer> sum = new ArrayList<Integer>();
		createIntegerList(a, lista);
		createIntegerList(b, listb);
		balanceSize(lista, listb);
		int length = lista.size();
		
		int c = 0;
		int d=0;
		for (int i = 0; i < length; i++) {
			
			d = (int) Math.floor((lista.get(i)+listb.get(i)+c)/2);
			sum.add(lista.get(i)+listb.get(i)+c -2*d);
			c=d;
			
		}
		if(c != 0){
		sum.add(c);
		}
		Collections.reverse(lista);
		Collections.reverse(listb);
		System.out.println(lista);
		System.out.println(listb);
		Collections.reverse(sum);
		System.out.println(sum);
		return sum;
	}
	
	public void createIntegerList(int a, List<Integer> list){
		int r=0;
		while(a>0){
			r=a % 10;
			a= a / 10;
			list.add(r);
		}
	}
	
	public void balanceSize(List a , List b){
		if(a.size() != b.size()){
			int i = Math.abs(a.size() - b.size());
			List target = a.size()<b.size()?a:b;
			while(i>0){
				target.add(0);
				i--;
			}
		}
	}
	
	
	public int getOneInteger(List<Integer> a){
		StringBuilder sb = new StringBuilder();
		for (Integer integer : a) {
			sb.append(integer);
		}
		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		//new BinaryAddition().addBinary(111110, 1011);
		new BinaryAddition().addBinary(110, 0);
		
	}
}
