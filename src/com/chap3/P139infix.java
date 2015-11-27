package com.chap3;

import com.collections.Stack;
import com.util.OperatorPrecedenceComp;

public class P139infix {

	public static String infixToPostfix(String exp) {
		Stack<Character> stackch = new Stack<>();
		String str = "";
		for (char ch : exp.toCharArray()) {
			if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
				if (stackch.isEmpty()|| OperatorPrecedenceComp.comparePrecedenceGreater(ch,	stackch.peek()) > 0) {
					stackch.push(ch);
					continue;
				}else{
					for(char chc:stackch ){
					if(OperatorPrecedenceComp.comparePrecedenceGreater(ch, stackch.peek()) <= 0){
						str = str + stackch.pop();
					}
					else{
						break;
					}
				}
					stackch.push(ch);
				}
			}else{
			str = str + ch;
		}
		}
		for (char chch : stackch) {
			str = str + chch;
		}
		return str;
	}

	public static void main(String[] args) {
		String infix = "a+b*c-d";
		System.out.println("infix " + infix);
		System.out.println("postfix " + infixToPostfix(infix));
		infix = "3+4*5/6";
		System.out.println("infix " + infix);
		System.out.println("postfix " + infixToPostfix(infix));
		infix = "(300+23)*(43-21)/(84+7)";
		System.out.println("infix " + infix);
		System.out.println("postfix " + infixToPostfix(infix));
		infix = "(4+8)*(6-5)/((3-2)*(2+2))";
		System.out.println("infix " + infix);
		System.out.println("postfix " + infixToPostfix(infix));
	}
}
