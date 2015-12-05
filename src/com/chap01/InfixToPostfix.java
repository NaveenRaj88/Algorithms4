package com.chap01;

import com.util.NumberUtils;
import com.util.OpertaorUtils;
import com.util.StackUtils;

public class InfixToPostfix {

	public void printInfixToPostfix(String exp) {
		String[] st = exp.split("");
		String finalExp = null;
		Stack<String> operand = new Stack<>();
		Stack<String> operator = new Stack<>();

		for (String s : st) {
			if (NumberUtils.isNumber(s)) {
				operand.push(s);
			}
			if (OpertaorUtils.isOperator(s)) {
				operator.push(s);
			}
			if (s.equals(")")) {
				String second = operand.pop();
				String first = operand.pop();
				operand.push(first+second+ operator.pop());
			}
		}
		operand=StackUtils.getnewStack(operand);
		operator=StackUtils.getnewStack(operator);
		while (!operator.isEmpty()) {
			operand.push(operand.pop()+operand.pop()+operator.pop());
		}
		System.out.println(operand.pop());
	}

	public static void main(String[] args) {
		InfixToPostfix inp = new InfixToPostfix();
		inp.printInfixToPostfix("1*(2+3)/4");
	}
}
