package com.chap3;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item> {

	private Item[] item ;
	private int n;
	
	public ResizingArrayQueueOfStrings() {
		item = (Item[]) new Object[10];
	}

	public ResizingArrayQueueOfStrings(int i) {
		item = (Item[]) new Object[i];
	}
	
	public void add(Item i){
		if(n==item.length){
			increase();
		}
		item[++n] = i;
	}
	
	private void increase(){
		Item[] temp =item;
		item = Arrays.copyOf(temp, item.length*2);
	}
	
	private void decrease(){
		Item[] temp =item;
		item = Arrays.copyOf(temp, item.length/2);
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
