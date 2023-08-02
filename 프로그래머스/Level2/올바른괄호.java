package PRGRMS.level2;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        int size = s.length();
        Stack<Character> stack = new Stack<>();

        if (s.charAt(0) == ')' || s.charAt(size - 1) == '(') return false;

        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);

            if (ch == '(') stack.push(ch);
            else if (ch == ')' && !stack.isEmpty()) stack.pop();
        }

        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}
