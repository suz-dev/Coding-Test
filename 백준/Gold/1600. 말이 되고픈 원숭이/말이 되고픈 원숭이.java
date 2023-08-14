import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] Hdrc = {{1, 2, 1, 2, -1, -2, -1, -2}, {2, 1, -2, -1, 2, 1, -2, -1}};   // 말 8방향
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};  // 원숭이 4방향
    static int k, w, h;
    static int[][] map;
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());   // c
        h = Integer.parseInt(st.nextToken());   // r

        map = new int[h][w];    // 0: 평지, 1: 장애물
        for (int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < w; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[h][w][k + 1];
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0, 0});   // r, c, kCnt, moveCnt
        visited[r][c][0] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == h - 1 && tmp[1] == w - 1) return tmp[3];  // 가장 먼저 도착

            // 말로 움직일 수 있는 거리가 남은 경우
            if (tmp[2] < k) {
                for (int d = 0; d < 8; d++) {
                    int nr = tmp[0] + Hdrc[0][d];
                    int nc = tmp[1] + Hdrc[1][d];

                    if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || visited[nr][nc][tmp[2]+1]) continue;

                    if (map[nr][nc] != 1) {
                        q.add(new int[]{nr, nc, tmp[2] + 1, tmp[3] + 1});
                        visited[nr][nc][tmp[2] + 1] = true;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || visited[nr][nc][tmp[2]]) continue;

                if (map[nr][nc] != 1) {
                    q.add(new int[]{nr, nc, tmp[2], tmp[3] + 1});
                    visited[nr][nc][tmp[2]] = true;
                }
            }
        }

        return -1;
    }
}