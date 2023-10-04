import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int N;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        
        N = tickets.length;
        visited = new boolean[N];
        
        dfs(tickets, "ICN", 0, "ICN");
        answer = pq.poll().split(",");
        
        return answer;
    }
    
    public static void dfs(String[][] tickets, String departure, int cnt, String path){
        if(cnt == N){
            pq.add(path);
            return;
        }
        
        for(int i = 0;i < N; i++){
            if(!visited[i] && departure.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt+1, path+","+tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}