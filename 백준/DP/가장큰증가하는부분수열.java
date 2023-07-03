package 백준.boj_230703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) dp[i] = dp[j] + arr[i];
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
