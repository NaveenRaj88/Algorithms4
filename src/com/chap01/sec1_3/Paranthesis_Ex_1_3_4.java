package com.chap01.sec1_3;

public class Paranthesis_Ex_1_3_4 {

	public boolean isBalanced(String exp) {
		String[] s = exp.split("");
		Stack<String> leftParen = new Stack<>();

		for (String string : s) {
			if(string.equals(")") || string.equals("]")||string.equals("}")){
				if(leftParen.isEmpty() || !isMatchingParen(leftParen.pop(), string)){
					return false;
				}
			}else{
				leftParen.push(string);
			}
		}
		return true;
	}

	public boolean isMatchingParen(String s1, String s2) {
		switch (s1) {
		case "(":
			return s2.equals(")");
		case "[":
			return s2.equals("]");
		case "{":
			return s2.equals("}");
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		Paranthesis_Ex_1_3_4 p = new Paranthesis_Ex_1_3_4();
		System.out.println(p.isBalanced("[()]{}{[()()]()}"));
		System.out.println(p.isBalanced("[(])"));
	}
}
