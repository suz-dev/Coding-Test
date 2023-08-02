package PRGRMS.level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        int answer = 1;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }

        if (!stack.isEmpty()) answer = 0;

        return answer;
    }
}
