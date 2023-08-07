import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown - 4) / 2;
        
        for(int i = 1; i < sum; i++){
            int j = sum - i;
            
            if(i * j == yellow){
                answer[0] = Math.max(i, j) + 2;
                answer[1] = Math.min(i, j) + 2;
            } 
        }
        
        
        return answer;
    }
}