package 백준.boj_230628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_1068 {

    static int n;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    // node 개수
        parent = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 부모 노드 입력
            parent[i] = Integer.parseInt(st.nextToken());
        }

        int remove = Integer.parseInt(br.readLine());   // 지울 노드
        removeNode(remove);

        System.out.println(countLeaf());

    }

    // node 삭제
    private static void removeNode(int idx) {
        parent[idx] = -2;
        visited[idx] = true;

        for (int i = 0; i < n; i++) {
            if (parent[i] == idx)
                removeNode(i);
        }
    }

    private static int countLeaf() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            if (isLeaf(i))
                sum++;
        }

        return sum;
    }

    private static boolean isLeaf(int idx) {
        visited[idx] = true;

        boolean leafTrue = true;
        for (int i = 0; i < n; i++) {
            if (parent[i] == idx) {
                leafTrue = false;
                break;
            }
        }

        return leafTrue;
    }
}
