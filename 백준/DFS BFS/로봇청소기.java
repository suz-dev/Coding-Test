package 백준.boj_230621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
    static int N, M, cnt;
    static int room[][];

    static int[][] drc = {{-1, 0, 1, 0}, {0, 1, 0, -1}};// 북동남서

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 방향 0북 , 1동, 2남, 3서
        cnt = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(cnt);
    }

    public static void dfs(int r, int c, int dir) {

        //현재 위치 청소
        room[r][c] = -1;

        //현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
            int nr = r + drc[0][dir];
            int nc = c + drc[1][dir];

            // 청소가 안된 곳이 있으면 cnt++,  dfs
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
                cnt++;
                dfs(nr, nc, dir);

                //여기서 return을 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할수가 있음.
                return;
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
        //뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
        int back = (dir + 2) % 4;
        int br = r + drc[0][back];
        int bc = c + drc[1][back];

        if (br >= 0 && br < N && bc >= 0 && bc < M && room[br][bc] != 1) {
            dfs(br, bc, dir);
        }
    }
}