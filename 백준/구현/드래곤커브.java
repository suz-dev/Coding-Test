package 백준.boj_230707;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {

    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());   // 시작 방향
            int g = Integer.parseInt(st.nextToken());   // 세대

            dragonCurve(x, y, d, g);
        }

        // 사각형 찾기 (유효 범위)
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);    // 시작 방향

        for (int i = 1; i <= g; i++) {  // 세대 반복
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);    // 방향 전환
            }
        }

        // 꼭지점 체크
        map[y][x] = true;
        for (Integer dir : list) {
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }
}