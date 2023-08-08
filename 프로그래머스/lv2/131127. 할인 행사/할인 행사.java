import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> map;
        boolean flag = false;
        
        for(int i = 0; i <= discount.length - 10; i++){
            map = new HashMap<>();
            
            // 10일 간 구매 가능 품목
            for(int j = i ; j < i + 10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            
            // 모두 구매 가능 검사
            flag = true;
            for(String key : want){
                if(map.get(key) != wantMap.get(key)){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}