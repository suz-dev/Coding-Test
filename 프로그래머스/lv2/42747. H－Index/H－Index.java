import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int cnt = 0;
        int h = 0;
        
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            
            h = citations.length - i;
            
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}