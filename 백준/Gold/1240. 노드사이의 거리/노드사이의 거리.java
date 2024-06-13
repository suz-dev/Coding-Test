import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<int[]>[] adjList;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new int[]{b, cost});
            adjList[b].add(new int[]{a, cost});
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            dfs(a, b, 0);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int from, int to, int cost) throws IOException {
        if(from == to){
            bw.write(cost + "\n");
        }

        visited[from] = true;

        for(int[] next : adjList[from]){
            if(visited[next[0]]) continue;

            dfs(next[0], to, cost + next[1]);
        }
    }
}