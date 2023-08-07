import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, ans = 0;
    static int[][] map;
    static int[][] drc = {{0, 1, 0, -1}, {-1, 0, 1, 0}};
    static int[] numOfMove = {1, 1, 2, 2};
    static int[][] drOfSand = {{-2, -1, -1, -1, 0, 1, 1, 1, 2}, {0, 1, 0, -1, 2, 1, 0, -1, 0}, {2, 1, 1, 1, 0, -1, -1, -1, -2}, {0, -1, 0, 1, -2, -1, 0, 1, 0}};
    static int[][] dcOfSand = {{0, -1, 0, 1, -2, -1, 0, 1, 0}, {-2, -1, -1, -1, 0, 1, 1, 1, 2}, {0, 1, 0, -1, 2, 1, 0, -1, 0}, {2, 1, 1, 1, 0, -1, -1, -1, -2}};
    static int[] percent = {2, 10, 7, 1, 5, 10, 7, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        tornado(N / 2, N / 2);  // 시작점

        System.out.println(ans);
    }

    private static void tornado(int r, int c) {

        // 현재 좌표
        int curR = r;
        int curC = c;

        while (true) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < numOfMove[d]; i++) {
                    int nr = curR + drc[0][d];
                    int nc = curC + drc[1][d];

                    if (nr < 0 || nc < 0 || N <= nr || N <= nc) return;

                    int sand = map[nr][nc];

                    map[nr][nc] = 0;

                    int spreadTotal = 0;    // 퍼진 모래
                    for (int s = 0; s < 9; s++) {   // 퍼지는 모래양 계산
                        int sandR = nr + drOfSand[d][s];
                        int sandC = nc + dcOfSand[d][s];
                        int spreadAmount = (sand * percent[s]) / 100;

                        if (sandR < 0 || sandC < 0 || N <= sandR || N <= sandC) ans += spreadAmount;    // 범위 밖으로 나가는 모래양
                        else map[sandR][sandC] += spreadAmount;

                        spreadTotal += spreadAmount;
                    }

                    // a 구역 모래
                    int aR = nr + drc[0][d];
                    int aC = nc + drc[1][d];
                    int aSand = sand - spreadTotal;

                    if (aR < 0 || aC < 0 || N <= aR || N <= aC) ans += aSand;
                    else map[aR][aC] += aSand;

                    // 좌표 갱신
                    curR = nr;
                    curC = nc;
                }
            }

            // 움직이는 범위 갱신
            for (int i = 0; i < 4; i++) {
                numOfMove[i] += 2;
            }
        }
    }
}
