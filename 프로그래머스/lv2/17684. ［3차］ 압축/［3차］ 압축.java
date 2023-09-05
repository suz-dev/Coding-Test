import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 초기화
        Map<String, Integer> map = new HashMap<>();
        
        int val = 1;
        for(int i = 'A'; i <='Z'; i++){
            map.put(String.valueOf((char)i), val++);
        }
        
        int idx = 0;
        while(idx < msg.length()){
            String w = "";
            
            while(idx < msg.length()){
                if(!map.containsKey(w+msg.charAt(idx))){
                    break;
                }else{
                    w += msg.charAt(idx);
                }
                idx++;
            }
            
            answer.add(map.get(w));
            if(idx < msg.length()){
                map.put(w+msg.charAt(idx), val++);
            }            
        }
        
        return answer;
    }
}