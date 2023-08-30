import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        
        Queue<Node> q = custom(priorities, location);
        
        while(!q.isEmpty()){
            Node tmp = q.poll();
            boolean state = false;
            
            for(Node n : q){
                if(tmp.val < n.val){
                    state = true;
                    break;
                }
            }
            
            if(state){
                q.offer(tmp);
                continue;
            }
            
            cnt++;
            
            if(tmp.loc) {
                answer = cnt;
            }
        }
        
        return answer;
    }   
    
    public static Queue<Node> custom(int[] priorities, int location){
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            boolean state = false;
            if(i == location){
                state = true;
            }
            q.offer(new Node(priorities[i], state));
        }
        
        return q;
    }
    
    
    static class Node{
        int val;
        boolean loc;
        
        public Node(int val, boolean loc){
            this.val = val;
            this.loc = loc;
        }
    }
}