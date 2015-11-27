package com.util;

public class OperatorPrecedenceComp {

	public static int comparePrecedenceGreater(char c, char d) {
		int cint = getPrecedenceValue(c);
		int dint = getPrecedenceValue(d);
		if (cint == -1 || dint == -1) {
			throw new RuntimeException("Only char data type is supported");
		}

		if (cint > dint) {
			return 1;
		} else if (c < d) {
			return -1;
		} else
			return 0;
	}

	private static int getPrecedenceValue(char c) {
		switch (c) {
		case '-':
			return 0;
		case '+':
			return 0;
		case '*':
			return 1;
		case '/':
			return 1;
		default:
			return -1;
		}

	}
}
