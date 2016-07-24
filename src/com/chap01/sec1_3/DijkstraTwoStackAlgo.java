package com.chap01.sec1_3;

import java.util.Stack;

/**
 * Created by Naveen Kumar .A on 7/23/16.
 */
public class DijkstraTwoStackAlgo {

    public static void evaluate(String expr) {
        Stack<String> operatorStack = new Stack<>();
        Stack<Double> operandStack = new Stack<>();
        for (String str : expr.split(" ")) {
            if (str.equals("(")) {
                continue;
            }else
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("sqrt")) {
                operatorStack.push(str);
            } else if(str.equals(")")){
                switch(operatorStack.pop()){
                    case "+":
                        operandStack.push(operandStack.pop()+operandStack.pop());
                        break;
                    case "-":
                        operandStack.push(operandStack.pop()- operandStack.pop());
                        break;
                    case "*":
                        operandStack.push(operandStack.pop() * operandStack.pop());
                        break;
                    case "/":
                        operandStack.push(operandStack.pop()/operandStack.pop());
                        break;
                    case "sqrt":
                        operandStack.push(Math.sqrt(operandStack.pop()));
                }
            }else{
                operandStack.push(Double.parseDouble(str));
            }

        }
        System.out.println(operandStack.pop());
    }

    public static void main(String[] args) {
        evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    }
}
