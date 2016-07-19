package com.leetcode.strings;

import java.util.Stack;

/**
 * Created by Dhaval on 7/18/2016.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * Algorithm : 1. Make a seive of opening and closing braces
 * 2. Initialize a stack which holds characters
 * 3. Iterate through the given string of braces, if you encounter an opening brace
 *    push it into stack
 * 4. If you encounter a closing bracket and stack is not empty then pop out from stack
 *    and check if the index of current closing brace and popped out character in the seive
 *    If the diffrence is not equal to 1 return false
 * 5. At the end check if the stack is empty then return true
 * 6. Or else return false as there is a missing pair
 *    Using a seive is much more elegant way as this improves the maintainability of the code
 *    and reduces the buch of if-else
 */
public class ValidParenthesis {
    public boolean isValid(String s) {

        //initialize seive
        String seive = "(){}[]";
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {

            char curr = s.charAt(i);
            if (curr == '[' || curr == '{' || curr == '(') stack.push(curr);
            else {
                if (!stack.isEmpty()) {
                    if (seive.indexOf(curr) - seive.indexOf(stack.pop()) != 1) return false;
                }
                else {
                    return false;
                }


            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid("{}[]()"));
    }
}
