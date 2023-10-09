import java.util.*;

// Prim
class Solution {
    
    static ArrayList<int[]>[] adjList;
    static boolean[] visited;
    
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        visited = new boolean[n];
        adjList = new ArrayList[n];
        
        for(int i = 0; i< n; i++){
            adjList[i] = new ArrayList<>();
        }
                
        for(int[] cost : costs){
            // 양방향
            adjList[cost[0]].add(new int[] {cost[0],cost[1],cost[2]});
            adjList[cost[1]].add(new int[] {cost[1], cost[0], cost[2]});   
        }
        
        // cost 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[2] - o2[2]);
        pq.add(new int[]{0,0,0});   // 첫번째 정점
        
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            
            int to = tmp[1];
            int cost = tmp[2];
            
            if(visited[to]) continue;
                        
            visited[to] = true;
            answer += cost;

            for(int[] i : adjList[to]){
                if(!visited[i[1]]) {
                    pq.add(i);
                }
            }            
        }
        
        return answer;
    }
}