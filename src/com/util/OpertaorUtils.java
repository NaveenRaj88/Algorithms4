package com.util;

public class OpertaorUtils {

	public static boolean isOperator(String s){
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}
}
