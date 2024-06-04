import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static ArrayList<Node>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        adjList = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();

        while(E-- > 0){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 단방향
            adjList[u].add(new Node(v, w));
        }

        dijkstra(start);

        for(int i = 1; i <= V; i++){
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : adjList[now.node]){
                if(dist[next.node] > dist[now.node] + next.w){
                    dist[next.node] = dist[now.node] + next.w;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    static class Node{
        int node, w;

        public Node(int node, int w){
            this.node = node;
            this.w = w;
        }
    }
}