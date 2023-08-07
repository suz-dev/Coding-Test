import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt = Integer.bitCount(n);
        int tmpCnt = 0;

        while(true){
            n++;
            tmpCnt = Integer.bitCount(n);
            
            if(cnt == tmpCnt) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}