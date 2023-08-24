import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, min, max, cnt = 0, ans = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 강수량
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] > max) max = map[i][j];
            }
        }

        for (int k = 0; k < max; k++) {
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= k || visited[i][j]) continue;

                    cnt++;
                    bfs(i, j, k);
                }
            }

            ans = Math.max(ans, cnt);
            cnt = 0;
        }

        System.out.println(ans);
    }

    private static void bfs(int r, int c, int rain) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = tmp.r + drc[0][d];
                int nc = tmp.c + drc[1][d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] <= rain) continue;

                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}