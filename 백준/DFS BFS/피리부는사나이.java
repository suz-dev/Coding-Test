package 백준.boj_230509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 1초
- 256MB
 */
public class 피리부는사나이 {

    static boolean[][] visited;
    static boolean[][] cycle;
    static int safeZone;
    static int[][] map;
    static int[][] drc = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int c = line.charAt(j);
                if (c == 'U') map[i][j] = 0;
                else if (c == 'D') map[i][j] = 1;
                else if (c == 'L') map[i][j] = 2;
                else if (c == 'R') map[i][j] = 3;
            }
        }

        // 사이클의 개수를 세면 된다.
        visited = new boolean[N][M]; // 방문한 위치
        cycle = new boolean[N][M]; // 사이클인지 확인한 위치

        safeZone = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) dfs(i, j);
            }
        }

        System.out.println(safeZone);
    }


    public static void dfs(int r, int c) {

        visited[r][c] = true;

        // 한방향만 탐색
        int nr = r + drc[0][map[r][c]];
        int nc = c + drc[1][map[r][c]];

        if (!visited[nr][nc]) {
            dfs(nr, nc);
        } else {
            if (!cycle[nr][nc]) safeZone++;
        }

        cycle[r][c] = true;
    }
}