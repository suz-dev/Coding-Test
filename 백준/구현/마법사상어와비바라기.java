package 백준.boj_230713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {

    // 8방향 : ←, ↖, ↑, ↗, →, ↘, ↓, ↙ (1-8)
    static int[][] drc = {{0, -1, -1, -1, 0, 1, 1, 1}, {-1, -1, 0, 1, 1, 1, 0, -1}};
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Cloud> clouds = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // first cloud info
        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            moveCloud(d, s);
            removeCloud();
            makeCloud();
        }

        // 물 양 구하기
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void moveCloud(int d, int s) {
        // 구름 이동 + 구름 칸 물의 양 1 증가
        for (Cloud cloud : clouds) {
            cloud.r = (n + cloud.r + drc[0][d] * (s % n)) % n;
            cloud.c = (n + cloud.c + drc[1][d] * (s % n)) % n;

            map[cloud.r][cloud.c]++;
        }
    }

    private static void removeCloud() {
        // 구름제거 + 물복사 버그마법 (대각선에 물바구니 있으면 물바구니 수만큼 증가)
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();

            int cnt = 0;    // 물바구니 수

            visit[cloud.r][cloud.c] = true;

            for (int i = 1; i <= 7; i += 2) {   // 대각선 탐색
                int nr = cloud.r + drc[0][i];
                int nc = cloud.c + drc[1][i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (map[nr][nc] >= 1)
                        cnt++;
                }
            }
            map[cloud.r][cloud.c] += cnt;
        }
    }

    private static void makeCloud() {
        // 물의양 2이상인 모든칸 구름 생기고 물양 2줄어들기 (단, 3에서 구름이 사라진 칸 무시)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visit = new boolean[n][n];  // 초기화
    }

    public static class Cloud {
        int r;
        int c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}