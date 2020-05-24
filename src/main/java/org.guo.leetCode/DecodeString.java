package org.guo.leetCode;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> resStack = new Stack<>();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch);
            } else {
                resStack.push(decodeString(stack));
            }
        }

        StringBuilder res = new StringBuilder();
        while(!resStack.empty()) {
            res.insert(0, resStack.pop());
        }
        return res.toString();
    }

    private String decodeString(Stack<Character> stack) {
        StringBuilder encoded = new StringBuilder();
        Character pop = null;
        while((pop = stack.pop()) != '[') {
            encoded.insert(0, pop);
        }
        StringBuilder repeat = new StringBuilder();
        while(!stack.empty() && Character.isDigit(stack.peek())) {
            repeat.insert(0, stack.pop());
        }
        String portion = encoded.toString();
        for (int j = 0; j < Integer.parseInt(repeat.toString()) - 1; j++) {
            encoded.append(portion);
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
