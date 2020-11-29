package old.queue;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.empty()) {
                stack.push(charArray[i]);
            } else {
                if (stack.peek() == '(' && charArray[i] == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && charArray[i] == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && charArray[i] == '}') {
                    stack.pop();
                } else
                    stack.push(charArray[i]);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "(({})";
        vp.isValid(s);
    }
}