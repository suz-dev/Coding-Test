import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1,o2) -> o1[0].compareTo(o2[0]));
        
        Map<Integer, int[]> rooms = new HashMap<>();
        int idx = 1;
        
        for(String[] str: book_time){
            String[] startTime = str[0].split(":");
            String[] endTime = str[1].split(":");
            
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]) + 10;
            
            if(rooms.isEmpty()) rooms.put(idx++, new int[]{start, end});
            else{
                boolean flag = false;
                int key = 0;
                
                for(Entry<Integer,int[]> entry : rooms.entrySet()){
                    key = entry.getKey();
                    int[] val = entry.getValue();
                    
                    if(start >= val[1]) {
                        flag = true;
                        break;
                    }
                }
                
                if(flag) rooms.put(key, new int[]{start, end});
                else rooms.put(idx++, new int[]{start, end});
            }
        }
        
        answer = rooms.size();
        return answer;
    }
}