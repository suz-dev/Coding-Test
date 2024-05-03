import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();    // 중요도 
        Queue<Integer> q = new LinkedList<>(); // 프로세스
        
        for(int i = 0; i < priorities.length; i++) {
            list.add(priorities[i]);
            q.add(i);
        }
        
        Collections.sort(list, Collections.reverseOrder()); // 내림차순 (중요도)
        
        while(true){
            int now = q.poll(); // 현재 프로세스 번호
            int nowP = list.get(answer);    // 우선순위
            
            if(priorities[now] != nowP) {
                q.add(now);
                continue;
            }          
            
            answer++;
            
            if(now == location) {
                break;
            }
        }
        
        return answer;
    }
}