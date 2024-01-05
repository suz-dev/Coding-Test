import java.util.*;

class Solution {
    
    static int[][] drc = {{-1,1,0,0}, {0,0,-1,1}};
    static int[][] map;
    static int[][] island;
    
    static int num = 0;
    static int H, W;
    
    static Map<Integer, Integer> hashMap = new HashMap<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        H = maps.length;
        W = maps[0].length();
        
        map = new int[H][W];
        island = new int[H][W];
                
        for(int i = 0; i < H; i++){
            String m = maps[i];
            for(int j = 0; j < W; j++){
                char ch = m.charAt(j);
                int k = 0;
                
                if(ch != 'X') k = ch - '0';
                map[i][j] = k;
            }
        }
        
        // island check
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(map[i][j] != 0 && island[i][j] == 0){
                    num++;
                    bfs(i, j);    
                }
            }
        }
        
        if(!hashMap.isEmpty()) answer = new int[hashMap.size()];
        else return new int[]{-1};
        
        int idx = 0;
        for(int val : hashMap.values()){
            answer[idx++] = val;
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        
        island[r][c] = num;
        int sum = map[r][c];
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];
                
                if(nr < 0 || nr > H-1 || nc < 0 || nc > W-1 || island[nr][nc] != 0 || map[nr][nc] == 0) continue;
                
                q.add(new int[]{nr, nc});
                island[nr][nc] = num;
                
                sum += map[nr][nc];
            }
        }
        
        hashMap.put(num, sum);  
    }
}