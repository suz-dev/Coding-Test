import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] dice = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}}; // 동 서 남 북
    static int[][] drc = {{0, 1, 0, -1}, {1, 0, -1, 0}};
    static int d = 0;
    static int score = 0;
    static int r = 0, c = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (K-- > 0) {
            moveDice();
            getScore();
            changeDist();
        }

        System.out.printf("%d", score);
    }

    public static void getScore() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int num = map[r][c];
        int cnt = 1;

        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                if (!checkRange(nr, nc) || visited[nr][nc] || map[nr][nc] != num) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});

                cnt++;
            }
        }

        score += cnt * num;
    }

    public static void moveDice() {
        int nx = r + drc[0][d];
        int ny = c + drc[1][d];

        //맵 바깥으로 나가면 방향이 반대로 바뀌어야함.
        if (!checkRange(nx, ny)) {
            d = (d + 2) % 4;
        }

        switch (d) {
            //동쪽
            case 0:
                int tmp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = tmp;
                break;
            //남쪽
            case 1:
                tmp = dice[3][1];
                for (int i = 3; i >= 1; i--) dice[i][1] = dice[i - 1][1];
                dice[0][1] = tmp;
                break;
            //서쪽
            case 2:
                tmp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = tmp;
                break;
            //북쪽
            case 3:
                tmp = dice[0][1];
                for (int i = 0; i < 3; i++) dice[i][1] = dice[i + 1][1];
                dice[3][1] = tmp;
                break;
        }

        r += drc[0][d];
        c += drc[1][d];
    }

    public static void changeDist() {
        int under = dice[3][1];
        int num = map[r][c];

        if (under > num) {
            d = (d + 1) % 4;
        } else if (under < num) {
            d = (d - 1);
            if (d < 0) d = 3;
        }
    }

    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}