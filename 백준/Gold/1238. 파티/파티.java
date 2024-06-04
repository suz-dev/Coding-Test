import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static int[] dist, rDist;
    static ArrayList<Node>[] adjList, rAdjList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 마을 수
        M = Integer.parseInt(st.nextToken());   // 도로 수
        X = Integer.parseInt(st.nextToken());   // 파티 위치

        dist = new int[N + 1];
        rDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(rDist, INF);

        adjList = new ArrayList[N + 1];
        rAdjList = new ArrayList[N+ 1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            rAdjList[i] = new ArrayList<>();
        }

        for(int i = 2; i <= M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, cost));
            rAdjList[b].add(new Node(a, cost));
        }

        dijkstra(adjList, dist, X); // 파티가는길
        dijkstra(rAdjList, rDist, X);   // 돌아오는길

        int max = 0;
        for(int i = 1; i <= N; i++) max = Math.max(max, dist[i] + rDist[i]);

        System.out.println(max);
    }

    public static void dijkstra(ArrayList<Node>[] arr, int[] dist, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : arr[now.node]){
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