import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int turnCnt = 1;
        
        Set<String> alreadyTold = new HashSet<>();
        String pre = words[0];
        alreadyTold.add(pre);
        
        for(int i = 1; i < words.length; i++){
            String now = words[i];
            
            if(alreadyTold.contains(now) || now.charAt(0) != pre.charAt(pre.length()-1)){
                answer[0] = i % n + 1;
                answer[1] = turnCnt;
                break;
            }
            
            alreadyTold.add(now);
            pre = now;

            if((i+1) % n == 0) turnCnt++;
        }

        return answer;
    }
}