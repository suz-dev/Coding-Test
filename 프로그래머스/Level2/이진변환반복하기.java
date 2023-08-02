package PRGRMS.level2;

import java.util.LinkedList;
import java.util.Stack;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
        }

        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    list.remove(i--);
                    answer[1]++;
                }
            }

            int val = list.size();
            list.clear();

            Stack<Integer> stack = new Stack<>();
            while (val > 1) {
                stack.push(val % 2);
                val /= 2;
            }

            list.add(1);
            while (!stack.isEmpty()) list.add(stack.pop());

            answer[0]++;
        }

        return answer;
    }

}
