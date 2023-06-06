package 백준.boj_230606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리_크루스칼 {

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

    static int V, E;
    static int[] parents; // 대표를 저장할 배열
    static ArrayList<Node> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수

        parents = new int[V + 1];
        nodeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 시작 정점
            int to = Integer.parseInt(st.nextToken()); // 도착 정점
            int cost = Integer.parseInt(st.nextToken()); // 가중치

            // 간선 정보 저장
            nodeList.add(new Node(from, to, cost));
        }

        // 가중치로 정렬
        Collections.sort(nodeList);

        // 나 자신을 대표로 초기화
        makeSet();

        // mst를 만들기 위해 간선 선택
        int sum = 0;
        int cnt = 0;

        for (Node node : nodeList) {
            if (union(node.from, node.to)) {
                sum += node.cost;
                cnt++;

                if (cnt == E - 1) break;
            }
        }
        System.out.println(sum);
    }

    // 나 자신을 대표로 초기화
    private static void makeSet() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    // 대표 찾기
    private static int findSet(int x) {
        if (x != parents[x]) {
            parents[x] = findSet(parents[x]);
        }
        return parents[x];
    }

    private static boolean union(int from, int to) {
        int fromParent = findSet(from);
        int toParent = findSet(to);

        if (fromParent == toParent) return false;
        else parents[toParent] = fromParent;
        return true;
    }
}
