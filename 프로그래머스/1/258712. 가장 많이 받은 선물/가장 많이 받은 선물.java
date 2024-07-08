import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int len = friends.length;
        Map<String, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < len; i++){
            hashmap.put(friends[i], i);
        }
        
        // 준선물, 받은선물, 선물 지수
        int[][] giftScore = new int[len][3];
        int[][] board = new int[len][len];
        
        for(String gift : gifts){
            String[] now = gift.split(" ");
            
            int a = hashmap.get(now[0]);
            int b = hashmap.get(now[1]);
                    
            board[a][b]++;
            
            // a -> b 선물
            giftScore[a][0]++;
            giftScore[b][1]++;
        }
        
        // 선물 지수
        for(int i = 0; i < len; i++) giftScore[i][2] = giftScore[i][0] - giftScore[i][1];
        
        int[] cnt = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                
                int give = board[i][j];
                int receive = board[j][i];
                
                if(receive < give) {
                    cnt[i]++;
                }else if(receive > give){
                    cnt[j]++;
                }else{
                    if(giftScore[i][2] > giftScore[j][2]) cnt[i]++;
                    else if(giftScore[i][2] < giftScore[j][2]) cnt[j]++;
                }
            }
        }
        
        for(int i : cnt) answer = Math.max(answer, i);
        
        return answer;
    }
}