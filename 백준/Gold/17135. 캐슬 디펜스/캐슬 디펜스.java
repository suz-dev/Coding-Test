import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, max = 0;
    static int[][] map;
    static boolean[] isSelected;   // 궁수 배치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());   // 제한거리

        map = new int[N + 1][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[M];
        combination(0, 0);

        System.out.println(max);
    }

    // 궁수배치
    private static void combination(int start, int cnt) {
        if (cnt == 3) {
            int[][] tmpMap = copyArr();
            int enemyCnt = castleDefense(tmpMap);
            max = Math.max(max, enemyCnt);  // 최대값 갱신

            return;
        }

        for (int i = start; i < M; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                combination(i, cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    private static int castleDefense(int[][] tmpMap) {
        int cnt = 0; // 제외된 적

        while (true) {
            if (endCheck(tmpMap)) break;    // 적 모두 소멸

            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                if (!isSelected[i]) continue;

                // dis -> c 정렬
                PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                    if (o1[2] == o2[2]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[2] - o2[2];
                    }
                });

                // 거리 계산 (1. 가장 가까운적 2. 가장 왼쪽 적)
                for (int r = N - 1; r >= 0; r--) {
                    for (int c = 0; c < M; c++) {
                        int dis = Math.abs(N - r) + Math.abs(i - c);
                        if (tmpMap[r][c] == 0 || dis > D) continue;
                        pq.add(new int[]{r, c, dis});
                    }
                }

                // 적 제거
                if (pq.isEmpty()) continue;
                list.add(pq.poll());

            }

            for (int[] tmp : list) {
                if (tmpMap[tmp[0]][tmp[1]] == 0) continue;
                tmpMap[tmp[0]][tmp[1]] = 0;
                cnt++;
            }

            // 적 위치 갱신
            tmpMap = enemyMove(tmpMap);
        }

        return cnt;
    }

    // 적 위치 갱신
    private static int[][] enemyMove(int[][] tmpMap) {
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = tmpMap[i - 1][j];
            }
        }
        Arrays.fill(tmpMap[0], 0);
        return tmpMap;
    }

    private static boolean endCheck(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static int[][] copyArr() {
        int[][] tmpMap = new int[N + 1][M];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        return tmpMap;
    }
}