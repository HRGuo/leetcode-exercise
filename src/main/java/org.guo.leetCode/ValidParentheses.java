package org.guo.leetCode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if(stack.isEmpty() || (char)stack.pop() != '(')
                    return false;
            } else if (s.charAt(i) == ']') {
                if(stack.isEmpty() || (char)stack.pop() != '[')
                    return false;
            } else if (s.charAt(i) == '}') {
                if(stack.isEmpty() || (char)stack.pop() != '{')
                    return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
