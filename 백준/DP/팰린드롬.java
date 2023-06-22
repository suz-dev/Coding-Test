package 백준.boj230622;

import java.io.*;
import java.util.StringTokenizer;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (isPelindrome(arr, s, e)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

        }
        System.out.print(sb);
    }

    private static boolean isPelindrome(int[] nums, int start, int end) {
        while (start <= end) {
            if (nums[start] != nums[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}