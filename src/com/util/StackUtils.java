package com.util;

import com.chap01.sec1_3.Stack;

public class StackUtils {
	
	public static <Item> Stack<Item> getnewStack(Stack<Item> stack){
		Stack<Item> newStack = new Stack<>();
		for (Item item : stack) {
			newStack.push(item);
		}
		return newStack;
	}
}
