package 백준.boj_230626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Dijkstra
public class 특정한최단경로 {
    static class Node implements Comparable<Node> {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        // 가중치 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N, E, ans;
    static List<Node>[] adjList;    // 인접리스트
    static int[] dist;  // 최단거리 저장
    static boolean[] visited; // 방문처리
    static final int INF = 200000000;   // 200000 * 1000 (간선 최대 개수 * 가중치 최댓값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수

        // 인접리스트 초기화
        adjList = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 최단거리 최대값으로 초기화
        dist = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 인접리스트에 넣기 (양방향)
            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start, weight));
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        ans = 0;

        // 1 > v1 > v2 > N
        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        // 1 > v2 > v1 > N
        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        if (ans1 >= INF && ans2 >= INF) ans = -1;
        else ans = Math.min(ans1, ans2);

        System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue();

        Arrays.fill(dist, INF); // 최단거리 배열 초기화
        Arrays.fill(visited, false);// 방문처리 배열 초기화

        dist[start] = 0; // 시작점은 거리 0
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) continue;   // 이미 최단경로 비용 알고 있음
            visited[now.v] = true;  // 방문처리

            // 간선 탐색 (최소값 갱신)
            for (Node next : adjList[now.v]) {
                if (dist[next.v] > next.weight + now.weight) {
                    dist[next.v] = next.weight + now.weight;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];   // 목적지 end 까지의 최단거리
    }
}
