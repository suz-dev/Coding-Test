package 백준.boj_230510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가중치
// 루트노드 : 1
// dfs

public class 트리의지름 {

    static class Node {
        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static ArrayList<Node> nodeList[];
    static int N;
    static int max = 0;
    static boolean visited[];
    static int maxIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodeList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[parent].add(new Node(child, weight));
            nodeList[child].add(new Node(parent, weight));
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int cnt) {
        // 갱신
        if (max < cnt) {
            max = cnt;
            maxIdx = idx;
        }

        for (Node node : nodeList[idx]) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                dfs(node.idx, cnt + node.cnt);
            }
        }
    }
}

