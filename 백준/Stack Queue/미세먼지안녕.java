package 백준.boj_230620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

    static int[][] drc = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int R, C, T;
    static int up, down;    // r

    static int[][] room, room2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());   // T초가 지난 후 남아있는 미세먼지 양

        // 공기청정기 위치 (r 기준으로 나뉨)
        up = 0;     // 반시계 순환
        down = 0;   // 시계 순환

        // 먼지 입력
        room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                // 공기청정기 위치
                if (up == 0 && room[i][j] == -1) up = i;
                else if (up != 0 && room[i][j] == -1) down = i;
            }
        }

        // 순환
        for (int i = 1; i <= T; i++) {
            dustSpread();
            upCycle();
            downCycle();
            roomClear();
        }

        int ans = 2;    //  공기청정기 값 제거
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += room2[i][j];
            }
        }

        System.out.println(ans);
    }

    // 미세먼지 확산
    private static void dustSpread() {
        room2 = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + drc[0][d];
                    int nc = c + drc[1][d];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                        room2[nr][nc] += (room[r][c] / 5);
                        cnt++;
                    }
                }
                room2[r][c] += room[r][c] - (room[r][c] / 5) * cnt;   // 남은 먼지
            }
        }
    }

    // 공기청정기 가동
    // up (반시계)
    private static void upCycle() {
        // 우 상 좌 하
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < C; i++) {
            q.add(room2[up][i]);
        }
        for (int i = up - 1; i >= 0; i--) {
            q.add(room2[i][C - 1]);
        }
        for (int i = C - 2; i >= 0; i--) {
            q.add(room2[0][i]);
        }
        for (int i = 1; i < up; i++) {
            q.add(room2[i][0]);
        }

        // 갱신
        for (int i = 2; i < C; i++) {
            room2[up][i] = q.poll();
        }
        for (int i = up - 1; i >= 0; i--) {
            room2[i][C - 1] = q.poll();

        }
        for (int i = C - 2; i >= 0; i--) {
            room2[0][i] = q.poll();
        }
        for (int i = 1; i < up; i++) {
            room2[i][0] = q.poll();
        }

        room2[up][1] = 0;
        q.clear();
    }

    // down (시계)
    private static void downCycle() {
        // 우 하 좌 상
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < C; i++) {
            q.add(room2[down][i]);
        }
        for (int i = down + 1; i < R; i++) {
            q.add(room2[i][C - 1]);
        }
        for (int i = C - 2; i >= 0; i--) {
            q.add(room2[R - 1][i]);
        }
        for (int i = R - 2; i > down; i--) {
            q.add(room2[i][0]);
        }

        // 갱신
        for (int i = 2; i < C; i++) {
            room2[down][i] = q.poll();
        }
        for (int i = down + 1; i < R; i++) {
            room2[i][C - 1] = q.poll();
        }
        for (int i = C - 2; i >= 0; i--) {
            room2[R - 1][i] = q.poll();
        }
        for (int i = R - 2; i > down; i--) {
            room2[i][0] = q.poll();
        }

        room2[down][1] = 0;
        q.clear();
    }

    // room condition 갱신
    private static void roomClear() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] = room2[i][j];
            }
        }
    }
}
