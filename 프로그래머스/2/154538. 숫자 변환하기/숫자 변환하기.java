import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        
        for (int i = x+1; i <= y; i++) {
            int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? dp[i / 2] : Integer.MAX_VALUE;
            int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? dp[i / 3] : Integer.MAX_VALUE;
            int c = x <= i - n ? dp[i - n] : Integer.MAX_VALUE;
            
            int d = Math.min(a, Math.min(b, c));

            dp[i] = d < Integer.MAX_VALUE ? d + 1 : Integer.MAX_VALUE;            
        }
        
        return dp[y] < Integer.MAX_VALUE ? dp[y] : -1;
    }
}