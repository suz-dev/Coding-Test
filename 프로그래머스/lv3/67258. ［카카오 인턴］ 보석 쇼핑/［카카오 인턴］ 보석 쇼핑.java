import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> allGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCnt = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        int min = Integer.MAX_VALUE;
        int start = 0;
        int tmpStart = 0;
        
        for(int i = 0; i < gems.length; i++){
            String gem = gems[i];
            
            gemCnt.put(gem, gemCnt.getOrDefault(gem, 0) + 1);
            q.offer(gem);
            
            while(true){
                String tmp = q.peek();
                
                if(gemCnt.get(tmp) > 1){
                    q.poll();
                    gemCnt.put(tmp, gemCnt.get(tmp) - 1);
                    tmpStart++;
                }else{
                    break;
                }
            }
            
            if(allGems.size() == gemCnt.size() && min > q.size()){
                min = q.size();
                start = tmpStart;
            }
        }
        
        answer[0] = start+1;
        answer[1] = start + min;
        return answer;
    }
} 