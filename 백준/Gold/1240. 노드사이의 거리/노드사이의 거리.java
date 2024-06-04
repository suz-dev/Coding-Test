import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   // 알고 싶은 쌍

        adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향
            adjList[a].add(new Node(b, cost));
            adjList[b].add(new Node(a, cost));
        }

        dist = new int[N + 1];
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Arrays.fill(dist, INF);
            dijkstra(start);
            System.out.println(dist[end]);
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : adjList[now.node]){
                if(dist[next.node] > dist[now.node] + next.cost){
                    dist[next.node] = dist[now.node] + next.cost;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    static class Node{
        int node, cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}