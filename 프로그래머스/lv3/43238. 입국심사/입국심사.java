import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;

        // times 배열의 최악의 경우는 범위
        // n명 기준으로 times의 가장 마지막 시간까지 탐색하는 경우.
    	long max = (long) times[times.length-1]*n;
    	long mid = 0;
    	long sum;   // 총 심사한 인원
    	long answer = max;

    	while(min <= max) {            
    		sum = 0;
    		mid = (min + max) / 2;

    		for(int time : times) {
    			sum += mid / time;
    		}
            
            // 심사해야 하는 인원보다 많은 경우 -> 최적조건 탐색
    		if(sum >= n) {
				answer = mid;
				max = mid - 1;
    		}
            // 심사해야 하는 인원보다 적은 경우 -> 시간 늘려서 탐색
    		else {
    			min = mid + 1;
    		}
    	}

        return answer;
    }
}