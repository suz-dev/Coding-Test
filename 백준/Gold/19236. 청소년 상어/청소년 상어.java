import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] drc = {{-1, -1, 0, 1, 1, 1, 0, -1}, {0, -1, -1, -1, 0, 1, 1, 1}};
    public static int ans;
    public static HashMap<Integer, Fish> hashMap;

    public static class Fish {
        int r, c, dir;

        public Fish(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hashMap = new HashMap<>();
        int[][] map = new int[4][4];

        // 입력
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                hashMap.put(num, new Fish(i, j, dir - 1));
            }
        }

        int sharkR = 0;
        int sharkC = 0;
        Fish first = hashMap.get(map[0][0]);
        ans = map[0][0];

        int sharkDir = first.dir;
        int num = map[0][0];

        map[0][0] = 0;
        hashMap.remove(num);

        dfs(map, hashMap, num, new Fish(sharkR, sharkC, sharkDir));

        System.out.println(ans);
    }

    public static void dfs(int[][] map, HashMap<Integer, Fish> hashMap, int sum, Fish shark) {
        ans = Math.max(ans, sum);   // 최대값 갱신

        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            copyMap[i] = map[i].clone();
        }

        HashMap<Integer, Fish> copyHashMap = (HashMap<Integer, Fish>) hashMap.clone();

        // 물고기 이동
        for (int k = 1; k <= 16; k++) {
            if (!hashMap.containsKey(k)) continue;

            Fish fish = copyHashMap.get(k);
            if (map[fish.r][fish.c] == 0) continue;

            int dir = fish.dir;
            boolean check = false;

            int nr = fish.r;
            int nc = fish.c;

            int turnCnt = 0;
            while (turnCnt++ < 8) {
                nr = fish.r + drc[0][dir];
                nc = fish.c + drc[1][dir];

                // 방향돌리기
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || (nr == shark.r && nc == shark.c)) {
                    dir = (dir + 1) % 8;
                } else {    // 이동 가능
                    check = true;
                    break;
                }
            }

            // 물고기 이동
            if (check) {
                if (copyMap[nr][nc] != 0) {
                    copyMap[fish.r][fish.c] = copyMap[nr][nc];

                    Fish moveFish = copyHashMap.get(copyMap[nr][nc]);
                    copyHashMap.put(copyMap[nr][nc], new Fish(fish.r, fish.c, moveFish.dir));

                    copyMap[nr][nc] = k;
                    copyHashMap.put(k, new Fish(nr, nc, dir));
                } else {
                    copyMap[nr][nc] = k;
                    copyHashMap.put(k, new Fish(nr, nc, dir));

                    copyMap[fish.r][fish.c] = 0;
                }
            }
        }

        // 상어 이동
        for (int k = 1; k <= 4; k++) {
            // 해당 방향에 있는 물고기 탐색
            int nr = shark.r + drc[0][shark.dir] * k;
            int nc = shark.c + drc[1][shark.dir] * k;

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) break;  // 범위 벗어남

            if (copyMap[nr][nc] != 0) {
                int num = copyMap[nr][nc];
                copyMap[nr][nc] = 0;
                int dir = copyHashMap.get(num).dir;
                copyHashMap.remove(num);

                // 상어가 다음 물고기 먹음
                dfs(copyMap, copyHashMap, sum + num, new Fish(nr, nc, dir));

                copyHashMap.put(num, new Fish(nr, nc, dir));
                copyMap[nr][nc] = num;
            }
        }
    }
}