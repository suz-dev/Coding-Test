import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int[][] map = new int[n+1][n+1];
        
        int startR = 1;
        int startC = 1;
        
        int endR = n;
        int endC = n;
    
        int snail = 1;
        while(startR <= endR && startC <= endC){
            // 아래로 채우기
            for(int r = startR; r <= endR; r++){
                map[r][startC] = snail++;
            }
            
            startR++;
            startC++;
            // 옆으로 채우기
            for(int c = startC; c <= endC; c++){
                map[endR][c] = snail++;
            }
            
            endR--;
            endC--;
            
            // 위로 채우기
            int tmpC = endC;
            for(int r = endR; r >= startR; r--){
                map[r][tmpC--] = snail++;
            }    
            
            startR++;
            endC--;
        }
        
        
        // answer 채우기
        int idx = 0;
        answer = new int[snail - 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 0) continue;
                answer[idx++] = map[i][j];
            }
        }
        
        
        
        return answer;
    }
}