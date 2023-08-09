import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(String[] str : clothes){
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }
        
        for(String keys : map.keySet()){
            answer *= (map.get(keys) + 1);      // 해당 옷을 안입는 경우의 수 추가
        }
        
        return answer - 1;      // 전부 안입는 경우의 수는 빼주기
    }
}