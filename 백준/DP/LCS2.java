package 백준.boj_230607;

import java.io.*;

public class LCS2 {

    static int r, c;
    static String A, B;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = br.readLine();
        B = br.readLine();

        r = A.length();
        c = B.length();

        // 길이
        int ans = LCS();

        // 부분 수열 (역순)
        StringBuilder sb = new StringBuilder();
        while (r != 0 && c != 0) {
            // 일치
            if (A.charAt(r - 1) == B.charAt(c - 1)) {
                sb.insert(0, A.charAt(r - 1));
                r--;
                c--;
            } else if (dp[r][c] == dp[r - 1][c]) {  // 위쪽 값이 같을 때
                r--;
            } else if (dp[r][c] == dp[r][c - 1]) {  // 왼쪽 값이 같을 때
                c--;
            }
        }
        // LCS 문자열 길이 출력
        bw.write(ans + "\n" + sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int LCS() {
        dp = new int[r + 1][c + 1];
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                // 같을 때
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 다를 때
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[r][c];
    }
}
