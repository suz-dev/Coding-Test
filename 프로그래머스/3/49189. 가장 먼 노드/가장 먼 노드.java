import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adjList;
    static int maxVal = 0;
    static int maxCnt = 0;
    static boolean[] visited;
    
    public static int solution(int n, int[][] edge) {
        
        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        visited = new boolean[n+1];
        bfs(1);
        
        return maxCnt;
    }
    
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        int size = 0;
        while(!q.isEmpty()){
            int cnt = 0;
            
            size = q.size();
            for(int i = 0; i < size; i++){
                int tmp = q.poll();                
                cnt++;
                
                for(Integer t : adjList[tmp]){
                    if(visited[t]) continue;
                    
                    q.add(t);
                    visited[t] = true;
                }
            }
            maxCnt = cnt;
        }
    }
}