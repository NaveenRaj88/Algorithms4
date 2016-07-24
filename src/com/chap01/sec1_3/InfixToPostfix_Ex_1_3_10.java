package com.chap01.sec1_3;

import com.util.NumberUtils;
import com.util.OpertaorUtils;
import com.util.StackUtils;

public class InfixToPostfix_Ex_1_3_10 {

	public void printInfixToPostfix(String exp) {
		String[] st = exp.split("");
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
				operand.push(first + second + operator.pop());
			}
		}
		operand = StackUtils.getnewStack(operand);
		operator = StackUtils.getnewStack(operator);
		while (!operator.isEmpty()) {
			operand.push(operand.pop() + operand.pop() + operator.pop());
		}
		System.out.println(operand.pop());
	}

	public static void main(String[] args) {
		InfixToPostfix_Ex_1_3_10 inp = new InfixToPostfix_Ex_1_3_10();
		inp.printInfixToPostfix("1*(2+3)/4");
	}
}