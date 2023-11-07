import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k;
    static int[][] restTime;
    static int[][] smell;
    static int[][][] priority;
    static Shark[] shark;
    static int[][] drc = {{0, -1, 1, 0, 0}, {0, 0, 0, -1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        restTime = new int[N + 1][N + 1];
        smell = new int[N + 1][N + 1];
        priority = new int[M + 1][5][4];
        shark = new Shark[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                
                if (n > 0) {    // 상어 존재
                    shark[n] = new Shark(i, j, 0);
                    restTime[i][j] = k;
                    smell[i][j] = n;
                }
            }
        }

        // 상어 현재 방향
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            shark[i].dir = Integer.parseInt(st.nextToken());

        // 상어 방향 별 우선순위
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bw.write(solve() + "\n");
        bw.flush();
    }

    public static int solve() {
        int time = 0;   // 걸린 시간

        while (true) {
            int count = 0;  // 남은 상어 수
            for (int m = 1; m <= M; m++) {
                if (shark[m] != null)
                    count++;
            }

            if (count == 1 && shark[1] != null) { // 1번 상어 혼자 남은 경우
                return time;
            }

            // 시간 초과
            if (time >= 1000)
                return -1;

            int[][] tmp = new int[N + 1][N + 1];

            for (int m = 1; m <= M; m++) {
                if (shark[m] != null) { // 상어가 경계 안에 있다면
                    moveShark(tmp, m);
                }
            }

            // 냄새 유효기간 하나씩 줄이기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (restTime[i][j] > 0)
                        restTime[i][j]--;

                    if (restTime[i][j] == 0)
                        smell[i][j] = 0;
                }
            }

            // 이동후의 상어 위치의 냄새 정보와 유효기간 초기화하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (tmp[i][j] > 0) {
                        restTime[i][j] = k;
                        smell[i][j] = tmp[i][j];
                    }
                }
            }
            time++;
        }
    }

    public static void moveShark(int[][] tmp, int m) {
        int nr = 0;
        int nc = 0;
        int d = 0;

        boolean flag = false;

        // 1-1. 높은 우선순위부터 차례대로 탐색
        for (int i = 0; i < 4; i++) {
            d = priority[m][shark[m].dir][i];
            nr = shark[m].r + drc[0][d];
            nc = shark[m].c + drc[1][d];

            // 경계를 벗어나지 않으면서, 냄새가 없는 곳을 찾으면 break로 빠져나옴
            if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
                flag = true;
                break;
            }
        }

        // 1-2. 냄새가 없는 곳이 없는 경우
        if (!flag) {
            for (int i = 0; i < 4; i++) {
                d = priority[m][shark[m].dir][i];
                nr = shark[m].r + drc[0][d];
                nc = shark[m].c + drc[1][d];

                if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == m)
                    break;
            }
        }

        if (tmp[nr][nc] == 0) {
            tmp[nr][nc] = m;
            shark[m].r = nr;
            shark[m].c = nc;
            shark[m].dir = d;
        } else {
            shark[m] = null;
        }
    }

    static class Shark {
        int r, c, dir;

        Shark(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}