import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
        int[][] dp = new int[2][n];
        
        if(n == 3) return Math.max(money[0], money[2]);
        
        // 첫번째 포함 + 마지막 미포함
        dp[0][0] = money[0];
        dp[0][1] = money[1];
        dp[0][2] = dp[0][0] + money[2];
        
        // 첫번째 미포함 + 마지막 포함
        dp[1][1] = money[1];
        dp[1][2] = money[2];
        
        for(int i = 3; i < n; i++){
            dp[0][i] = Math.max(dp[0][i - 2], dp[0][i - 3]) + money[i];
            dp[1][i] = Math.max(dp[1][i - 2], dp[1][i - 3]) + money[i];
        }

        answer = Math.max(Math.max(dp[0][n - 3],dp[0][n - 2]), dp[1][n - 1]);
        
        return answer;
    }
}