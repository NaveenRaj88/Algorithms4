package com.chap01.sec1_3;

import com.util.NumberUtils;
import com.util.OpertaorUtils;

public class EvaluatePostfix_Ex_1_3_11 {

	public static void isValidPostFix(String exp){
		Stack<String> operandStack  = new Stack<>();
		for(String str : exp.split("")){
			if(NumberUtils.isNumber(str)){
				operandStack.push(str);
			}else if(OpertaorUtils.isOperator(str)){
				if(operandStack.size()<2){
					System.out.println(exp +"is not a valid Expression");
					return;
				}
				String secondOperand = operandStack.pop();
				String firstOperand = operandStack.pop();
				operandStack.push(firstOperand+str+secondOperand);
			}
		}
			System.out.println(exp +"is a valid Expression");
	}
	public static void main(String[] args) {
		isValidPostFix("123+*4/");
	}
}
