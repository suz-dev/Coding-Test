package 백준.boj_230601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[][] drc = {{0, 0, -1, 1}, {-1, 1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int sr = 0;
        int sc = 0;

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    sr = i;
                    sc = j;
                }
            }
        }

        visited = new boolean[n][m];
        bfs(new Node(sr, sc));

        // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = tmp.x + drc[0][d];
                int ny = tmp.y + drc[1][d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    map[nx][ny] = map[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
