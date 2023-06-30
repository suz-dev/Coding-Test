package 백준.boj_230630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijkstra
public class 서강그라운드 {
    static class Position implements Comparable<Position> {

        int posNum; // 지역 번호
        int weight; // 거리 (가중치)

        public Position(int posNum, int weight) {
            this.posNum = posNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(Position o) {
            return this.weight - o.weight;
        }
    }

    static int n, m, r;
    static int[] items; // 지역별 아이템  
    static int[] dist;   // 최단거리 배열
    static boolean[] visited; // 방문체크
    static ArrayList<ArrayList<Position>> adjList;  // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 지역의 개수
        m = Integer.parseInt(st.nextToken());   // 수색범위 (수색 가능한 가중치의 합 <= 수색범위)
        r = Integer.parseInt(st.nextToken());   // 길의 개수

        items = new int[n + 1]; // 각 지역의 아이템 1~n
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 인접리스트 초기화
        adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // 양방향 인접리스트 구현
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());   // 가중치

            adjList.get(start).add(new Position(end, weight));
            adjList.get(end).add(new Position(start, weight));
        }

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {   // 각 지역별 dijkstra 탐색
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    // Dijkstra (pq)
    private static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Position curr = pq.poll();
            int pos = curr.posNum;

            if (!visited[pos]) {
                visited[pos] = true;

                for (Position position : adjList.get(pos)) {
                    if (!visited[position.posNum] && dist[position.posNum] > dist[pos] + position.weight) {
                        dist[position.posNum] = dist[pos] + position.weight;
                        pq.add(new Position(position.posNum, dist[position.posNum]));
                    }
                }
            }
        }

        // 수색범위 내부의 값 찾기
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                res += items[i];
            }
        }

        return res;
    }
}
