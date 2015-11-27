package com.chap3;

import com.collections.Stack;

public class P134Paranthesis {

	private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';
    
	public boolean evaluate(String str){
		Stack<Character> chStack = new Stack<>();
		boolean flag = true;
		for (Character character : str.toCharArray()) {
			if(character.equals(LEFT_BRACE)||character.equals(LEFT_BRACKET)||character.equals(LEFT_PAREN)){
				chStack.push(character);
			}
			else {
				switch (character) {
				case RIGHT_BRACE:
					if(!chStack.pop().equals(LEFT_BRACE))
						return false;
						break;
				case RIGHT_BRACKET:
					if(!chStack.pop().equals(LEFT_BRACKET))
						return false;
					break;
				case RIGHT_PAREN:
					if(!chStack.pop().equals(LEFT_PAREN))
						return false;
					break;
				}
			}
		}
		return flag;
		
	}
	
	public static void main(String[] args) {
		P134Paranthesis p = new P134Paranthesis();
		String inp = "[()]{}{[()()]()}";
		System.out.println(p.evaluate(inp));
	}
}
