package com.leetcode.strings;

import java.util.Stack;

/**
 * Created by Dhaval on 8/9/2016.
 */
public class BasicCalculatorII {

    public int calculate(String s) {

        s = s.trim();
        s= s.replaceAll("\\s+", "");
        int len = s.length();
        if (len < 1) return 0;
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int p1 = 0;
        int p2 = 0;


        while (p1 < len && p2 < len) {
            char curr = s.charAt(p2);
            if (isOperator(curr)) {
                operandStack.push(Integer.valueOf(s.substring(p1, p2)));
                while (!operatorStack.isEmpty() && isOfEqLowerPriority(curr, operatorStack.peek())) {

                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    operandStack.push(performOperation(operand1, operand2, operatorStack.pop()));
                }
                operatorStack.push(curr);
                p2++;
                p1 = p2;
            }
            else{
                p2++;
            }

            //
        }

        operandStack.push(Integer.valueOf(s.substring(p1, p2)));
        while (!operatorStack.isEmpty()) {

            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            operandStack.push(performOperation(operand1, operand2, operatorStack.pop()));

        }

        return operandStack.pop();

    }

    private boolean isOperator(char curr) {

        if (curr == '+' || curr == '-' || curr == '*' || curr == '/') return true;
        return false;
    }

    private boolean isOfEqLowerPriority(char curr, char prev) {

        if (curr == '+') return true;
        if (curr == '-') return true;
        if (curr == '*' && (prev == '/' || prev == '*')) return true;
        if (curr == '/' && (prev == '/' || prev == '*')) return true;
        return false;
    }

    private int performOperation(int operand1, int operand2, char operator) {

        switch (operator) {

            case '+':
                return operand1 + operand2;

            case '-':
                return operand1 - operand2;

            case '*':
                return operand1 * operand2;

            case '/':
                return operand1 / operand2;

        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        System.out.println(new BasicCalculatorII().calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
    }

}
