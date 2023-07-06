package 백준.boj_230706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int c = 2; c <= N; c++) {
                dp[0][c] = Math.max(dp[1][c - 1], dp[1][c - 2]) + stickers[0][c];
                dp[1][c] = Math.max(dp[0][c - 1], dp[0][c - 2]) + stickers[1][c];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
