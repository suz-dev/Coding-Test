import java.util.*;
import java.io.*;

// 공통부분 문자열
public class Main {
    public static int solution(String a, String b) {
        int answer = 0;

        int r = a.length();
        int c = b.length();
        int[][] dp = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(a.charAt(i) == b.charAt(j)) {
                    if(i == 0 || j == 0) dp[i][j]++;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        System.out.println(solution(a, b));
    }
}