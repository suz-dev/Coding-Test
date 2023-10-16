import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        
        while(true){
            int a = pq.poll();
            if(a >= K) break;
            
            if(pq.isEmpty()) return -1;
            
            int b = pq.poll();
            int c = a + b * 2;
            
            answer++;  
            pq.add(c);
        }
        
        return answer;
    }
}