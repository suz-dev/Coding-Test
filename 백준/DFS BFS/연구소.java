package 백준.boj_230530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    // 상하좌우 탐색
    static final int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static int map[][];
    static int N, M;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
    }

    // 벽세우기
    static void dfs(int wallCnt) {
        // 벽이 3개일 때 bfs 탐색 시작
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {   // 벽이 아닐 때
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {   // 바이러스 지점
                    q.add(new Node(i, j));
                }
            }
        }

        // 원본맵 대신 사용
        int copyMap[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + drc[0][d];
                int ny = y + drc[1][d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        checkSafeZone(copyMap);
    }

    // SafeZone 확인
    private static void checkSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        // 최대값 갱신
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    // x, y 좌표 Node
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
