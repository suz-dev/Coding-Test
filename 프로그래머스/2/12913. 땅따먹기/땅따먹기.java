import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int size = land.length;
        
        // dp
        int[][] dp = new int[size][4];
        
        // 첫줄 초기화
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        
        for(int i = 1; i < size; i++){
            
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;
                    
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }         
        }
        
        answer = Math.max(dp[size-1][0], Math.max(dp[size-1][1], Math.max(dp[size-1][2], dp[size-1][3])));
        
        return answer;
    }
}