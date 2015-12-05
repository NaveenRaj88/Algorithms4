package com.chap01;

public class InfixExpression {

	public void infixExp(String exp) {
		String[] st = exp.split("");
		Stack<String> operand = new Stack<>();
		Stack<String> operator = new Stack<>();
		for (String s : st) {
			if (s.equals(")")) {
				String second = operand.pop();
				String first = operand.pop();
				operand.push("(" + first + operator.pop() + second+ s);
			}
			if (isNumber(s)) {
				operand.push(s);
			}
			if (isOperator(s)) {
				operator.push(s);
			}
		}
		
			System.out.println(operand.pop());
	}

	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		InfixExpression in = new InfixExpression();
		in.infixExp("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");

	}
}
