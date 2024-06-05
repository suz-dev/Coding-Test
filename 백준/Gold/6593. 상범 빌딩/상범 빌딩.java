import java.util.*;
import java.io.*;

// 3차원 bfs
public class Main {

    static int L, R, C, ans;
    static char[][][] map;  // 동서남북상하
    static boolean[][][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};    // 동서남북
    static int[] startLRC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            ans = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            int sl = 0;
            int sr = 0;
            int sc = 0;

            map = new char[L + 1][R + 1][C + 1];
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    String str = br.readLine();
                    for (int c = 1; c <= C; c++) {
                        map[l][r][c] = str.charAt(c - 1);

                        if (map[l][r][c] == 'S') {
                            sl = l;
                            sr = r;
                            sc = c;
                        }
                    }
                }

                String string = br.readLine();
            }

            // bfs
            visited = new boolean[L + 1][R + 1][C + 1];
            bfs(sl, sr, sc);

            System.out.println(ans == Integer.MAX_VALUE ? "Trapped!" : "Escaped in " + ans + " minute(s).");
        }
    }

    public static void bfs(int sl, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sl, sr, sc, 0});
        visited[sl][sr][sc] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int l = now[0];
            int r = now[1];
            int c = now[2];
            int cnt = now[3];

            // 종료 조건
            if (map[l][r][c] == 'E') {
                ans = cnt;
                return;
            }

            for (int d = 0; d < 6; d++) {

                int nl = l;
                int nr = r;
                int nc = c;

                if (d == 4) { // 상
                    nl++;
                } else if (d == 5) { // 하
                    nl--;
                } else {    // 동서남북
                    nr = r + drc[0][d];
                    nc = c + drc[1][d];
                }

                if (nl > L || nl < 1 || nr < 1 || nr > R || nc < 1 || nc > C || visited[nl][nr][nc] || map[nl][nr][nc] == '#') continue;

                visited[nl][nr][nc] = true;
                q.add(new int[]{nl, nr, nc, cnt + 1});
            }
        }
    }
}