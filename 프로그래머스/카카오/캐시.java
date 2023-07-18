package PRGRMS.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    static final int HIT = 1;
    static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 예외 조건
        if (cacheSize == 0) return cities.length * MISS;

        Queue<String> cache = new LinkedList<>();
        for (String city : cities) {
            String s = city.toLowerCase();

            if (cache.contains(s)) {  // HIT
                if (cache.size() == cacheSize) {
                    cache.remove(s);
                }
                cache.add(s);
                answer += HIT;
            } else {  // MISS
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.add(s);
                answer += MISS;
            }
        }

        return answer;
    }
}
