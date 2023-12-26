import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);    // index, value 
        
        for(int i = 0; i < numbers.length; i++){
            int now = numbers[i];
            
            while(!pq.isEmpty() && pq.peek()[1] < now){
                answer[pq.poll()[0]] = now;
            }
            
            pq.add(new int[]{i, now});
        }
        
        while(!pq.isEmpty()){
            answer[pq.poll()[0]] = -1;
        }
        
        return answer;
    }
}