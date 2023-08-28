import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int N = 10;
    static int[][] map;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (ans == Integer.MAX_VALUE) ans = -1;

        bw.write(ans + "\n");
        bw.close();
        br.close();
    }

    // DFS + 백트래킹
    public static void dfs(int x, int y, int cnt) {
        // 맨 끝점에 도달하였을 경우, ans와 cnt 비교하고 종료.
        if (x >= N - 1 && y > N - 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 최소값 check
        if (ans <= cnt) {
            return;
        }

        // 아래 줄로 이동
        if (y > N - 1) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    // 색종이 붙이기
                    attach(x, y, i, 0); 
                    paper[i]--;
                    dfs(x, y + 1, cnt + 1);
                    
                    // 원상복귀 (색종이 떼기)
                    attach(x, y, i, 1); 
                    paper[i]++;
                }
            }
        } else { // 오른쪽으로 이동
            dfs(x, y + 1, cnt);
        }
    }

    // 색종이 붙이기
    public static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }

    // 색종이를 붙일 수 있는지 확인
    public static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N || map[i][j] == 0) return false;
            }
        }
        return true;
    }
}