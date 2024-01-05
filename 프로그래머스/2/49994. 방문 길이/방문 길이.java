import java.util.*;

class Solution {
    
    static int[][] drc = {{-1,0,1,0},{0,1,0,-1}};   // U R D L
    
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] map = new int[21][21];
                    
        // 초기 좌표
        int x = 10;
        int y = 10;
                
        map[x][y] = 1;
        
        for(int i = 0; i < dirs.length(); i++){
            char ch = dirs.charAt(i);
            
            int dir = -1;
            if(ch == 'U') dir = 0;
            if(ch == 'R') dir = 1;
            if(ch == 'D') dir = 2;
            if(ch == 'L') dir = 3;
            
            int nx = x + drc[0][dir];
            int ny = y + drc[1][dir];
            
            int nx2 = x + drc[0][dir] * 2;
            int ny2 = y + drc[1][dir] * 2;
            
            // 범위 벗어남
            if(nx2 < 0 || nx2 > 20 || ny2 < 0 || ny2 > 20) continue;
            
            // 길
            if(map[nx][ny] == 0) {
                answer++;
                map[nx][ny] = 1;
            }
            
            // 방문 좌표
            if(map[nx2][ny2] == 0){
                map[nx2][ny2] = 1;
            }
            
            // 좌표 갱신
            x = nx2;
            y = ny2;
        }
        
        return answer;
    }
}