import java.util.*;
import java.io.*;

public class Main {
    static int[] arr, dp;
    static int N, ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(i == 0) dp[i] = arr[i];
            else dp[i] = dp[i - 1] + arr[i];
        }

        twoPointer(0, N - 1);
        twoPointerLeft(0, N - 1);
        twoPointerRight(0, N - 1);

        System.out.println(ans);
    }

    // 꿀타래가 중간일 때
    static void twoPointer(int startIdx, int endIdx){
        for(int midIdx = startIdx + 1; midIdx < endIdx; midIdx++) {
            int leftSum = dp[midIdx] - arr[startIdx];
            int rightSum = dp[endIdx - 1] - dp[midIdx - 1];

            ans = Math.max(ans, leftSum + rightSum);
        }
    }

    // 꿀타래가 왼쪽일 때
    static void twoPointerLeft(int startIdx, int endIdx){
        for(int midIdx = endIdx - 1; midIdx > startIdx; midIdx--) {
            int leftSum = dp[midIdx - 1];
            int rightSum = dp[endIdx - 1] - arr[midIdx];

            ans = Math.max(ans, leftSum + rightSum);
        }
    }

    // 꿀타래가 오른쪽일 때
    static void twoPointerRight(int startIdx, int endIdx){
        for(int midIdx = startIdx + 1; midIdx < endIdx; midIdx++) {
            int leftSum = dp[endIdx] - arr[startIdx] - arr[midIdx];
            int rightSum = dp[endIdx] - dp[midIdx];

            ans = Math.max(ans, leftSum + rightSum);
        }
    }
}