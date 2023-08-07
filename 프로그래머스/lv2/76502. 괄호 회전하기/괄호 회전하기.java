import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        ArrayList<Character> list1 = new ArrayList<>(Arrays.asList('[', '{', '('));
        ArrayList<Character> list2 = new ArrayList<>(Arrays.asList(']', '}', ')'));
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0;i < len; i++){
            q.offer(s.charAt(i));
        }
        
        if(len % 2 > 0) return 0;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            boolean flag = false;

            for(int j = 0; j < len; j++){
                char ch = q.poll();
                
                if(list1.contains(ch)) {
                    stack.push(ch);
                    flag = true;
                }else if(!stack.isEmpty() && list2.contains(ch)){
                    if(stack.peek() == '[' && ch == ']' || stack.peek() == '{' && ch == '}' || stack.peek() == '(' && ch == ')') stack.pop();
                } 
                
                q.offer(ch);   
            }
            
            if(flag && stack.isEmpty()) answer++;
            q.offer(q.poll());
            stack.clear();
            
            System.out.println();
        }
        
        return answer;
    }
}