import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        int i = 0;
        int j = 0;
        int idx;
        int len;

        for (i = 0; i < k; i++) {   // k개의 문자 제거
            len = sb.length();
            idx = len - 1;
            for (j = 0; j < len - 1; j++) {
                if (sb.charAt(j) < sb.charAt(j + 1)) {  // 첫번째 자리가 최대값이 될 수 있는 수 찾기
                    idx = j;
                    break;
                }
            }

            sb.deleteCharAt(idx);
        }

        return sb.toString();
    }
}