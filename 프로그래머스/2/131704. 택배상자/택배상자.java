import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int[] items = new int[order.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = i + 1;
        }

        int orderIdx = 0;
        int itemIdx = 0;

        while (itemIdx < order.length && orderIdx < order.length) {
            int orderItem = order[orderIdx];

            if (items[itemIdx] == orderItem) {
                answer++;
                itemIdx++;
                orderIdx++;
                
                // 마지막
                if (itemIdx == order.length) {
                    while (!stack.isEmpty() && orderIdx < order.length && order[orderIdx] == stack.pop()) {
                        orderIdx++;
                        answer++;
                    }
                }
                
            } else {
                if (!stack.isEmpty() && stack.peek() == orderItem) {
                    stack.pop();
                    orderIdx++;
                    answer++;
                } else if (!stack.isEmpty() && stack.peek() != orderItem) {
                    stack.push(items[itemIdx]);
                    itemIdx++;
                } else {
                    stack.push(items[itemIdx]);
                    itemIdx++;
                }
            }
        }

        return answer;
    }
}