import java.util.*;

class Solution {
    
    public static int N, M;
    public static boolean[][] visited;
    public static int[][] Map;
    public static int[][] drc = {{0,0,1,-1}, {1,-1,0,0}};
    
    public static int solution(int[][] maps) {
        int answer = -1;
        
        Map = maps;
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        answer = bfs(0,0);
        
        return answer;
    }
    
    public static int bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,1});
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            if(tmp[0] == N - 1 && tmp[1] == M - 1){
                return tmp[2];
            }
            
            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || Map[nr][nc] == 0) continue;
                
                q.add(new int[]{nr, nc, tmp[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}