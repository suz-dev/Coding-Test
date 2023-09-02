import java.util.*;

class Solution {  
    public static int solution(int n, int k) {
        int answer = 0;
        
        String[] nums = toBinary(n,k).split("0+");

        for (String s : nums) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}