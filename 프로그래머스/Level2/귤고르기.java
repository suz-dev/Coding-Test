package PRGRMS.level2;

import java.util.Arrays;

public class 귤고르기 {
    static final int LEN = 10000000;

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] arr = new int[LEN + 1];
        for (int t : tangerine) {
            arr[t - 1]++;
        }

        Arrays.sort(arr);

        int idx = LEN;
        while (k > 0) {
            if (arr[idx] > 0) {
                answer++;
                k -= arr[idx];
                idx--;
            }
        }

        return answer;
    }
}