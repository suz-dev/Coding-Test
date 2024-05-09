import java.util.*;

class Solution {
    
       static int R, answer = Integer.MAX_VALUE;
    static char[] arr;

    public static int solution(int storey) {
        arr = String.valueOf(storey).toCharArray();
        R = arr.length;

        dfs(R - 1, R, 0, 0);

        return answer;
    }

    public static void dfs(int idx, int cnt, int sum, int plus){
        if(sum > answer) return;

        if(cnt == 0){
            answer = Math.min(answer, (sum + plus));
            return;
        }

        int now = arr[idx] - '0' + plus;

        if(now > 5) dfs(idx - 1, cnt - 1, sum + (10 - now), 1); // 올림
        if(now < 5) dfs(idx - 1, cnt - 1, sum + now, 0); // 내림
        if(now == 5) {
            dfs(idx - 1, cnt - 1, sum + (10 - now), 1); // 올림
            dfs(idx - 1, cnt - 1, sum + now, 0); // 내림
        }
    }
}