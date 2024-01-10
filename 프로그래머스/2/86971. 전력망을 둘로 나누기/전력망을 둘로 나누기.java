import java.util.*;

class Solution {
    
    static int cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
    
        for(int i = 0; i < wires.length; i++){
            
            for(int j = 0; j <= n; j++) graph[j] = new ArrayList<>();
            
            int start = 0;
            for(int j = 0; j < wires.length; j++){
                int from = wires[j][0];
                int to = wires[j][1];
            
                if(i == j) continue;
            
                graph[from].add(to);
                graph[to].add(from);
            
                start = j;
            }
            
            cnt = 1;
            visited = new boolean[n+1];
            dfs(start);
        
            answer = Math.min(answer, Math.abs(cnt * 2 - n));  
        }
    
        return answer;
    }
    
    public static void dfs(int start){
        visited[start] = true;
        
        for(int i= 0; i < graph[start].size(); i++){
            int now = graph[start].get(i);
            
            if(visited[now]) continue;
            
            cnt++;
            dfs(now);
        }
    }
}