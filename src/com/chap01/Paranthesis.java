package com.chap01;

public class Paranthesis {

	public boolean isBalanced(String exp) {
		String[] s = exp.split("");
		Stack<String> stck1 = new Stack<>();
		Stack<String> stck2 = new Stack<>();
		for (String string : s) {
			stck1.push(string);
		}
		while (!stck1.isEmpty()) {
			String paren = stck1.pop();
			if (stck2.isEmpty()) {
				stck2.push(paren);
				continue;
			}
			String paren2 = stck2.pop();
			if (isMatchingParen(paren, paren2)) {
				continue;
			} else {
				stck2.push(paren2);
				stck2.push(paren);
			}
			if (stck2.size() > stck1.size()) {
				return false;
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
		Paranthesis p = new Paranthesis();
		System.out.println(p.isBalanced("[()]{}{[()()]()}"));
		System.out.println(p.isBalanced("[(])"));
	}
}
