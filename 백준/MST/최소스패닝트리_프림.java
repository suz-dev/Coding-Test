package 백준.boj_230606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리_프림 {

    static class Node implements Comparable<Node> {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        // 정렬
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int V, E, ans;

    static boolean visited[];

    static ArrayList<Node>[] nodeList;  // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수

        visited = new boolean[V + 1];
        nodeList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 시작 정점
            int to = Integer.parseInt(st.nextToken()); // 도착 정점
            int cost = Integer.parseInt(st.nextToken()); // 가중치

            // 간선 정보 저장
            nodeList[from].add(new Node(from, to, cost));
            nodeList[to].add(new Node(to, from, cost));
        }

        // 가중치로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,1,0)); // 시작 정점?

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int to = n.to;
            int cost = n.cost;

            if(visited[to]) continue;
            visited[to] = true;
            ans += cost;

            for (Node node : nodeList[to]) {
                if(!visited[node.to]) pq.add(node);
            }
        }

        System.out.println(ans);

    }
}
