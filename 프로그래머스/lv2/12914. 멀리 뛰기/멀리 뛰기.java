class Solution {
    public long solution(int n) {
        long answer = 0;
        
        if(n == 1) return (long)1;
        
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <=  n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        answer = dp[n];
        return answer;
    }
}