package com.chap01;

public class DijkstraTwoStackAlg {

	public static double evaluate(String exp) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		for (String s : exp.split(" ")) {
			if (s.equals(" ") || s.equals("(") || s.equals("")) {
				continue;
			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				double val = vals.pop();
				if (op.equals("+")) {
					val = val + vals.pop();
				} else if (op.equals("-")) {
					val = vals.pop() - val;
				} else if (op.equals("*")) {
					val = vals.pop() * val;
				} else if (op.equals("/")) {
					val = vals.pop() / val;
				} else if (op.equals("sqrt")) {
					val = Math.sqrt(val);
				}
				vals.push(val);
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		return vals.pop();
	}

	public static void main(String[] args) {
		System.out.println(evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
		System.out.println(evaluate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"));
	}
}
