package 백준.boj_230602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 게임이 몇 초에 끝나는지 출력
// 뱀은 매 초마다 이동함
public class 뱀 {
    static int N, d = 0;
    static int[][] map;
    static Map<Integer, String> moveInfo;
    static int[][] drc = {{1, 0, -1, 0}, {0, 1, 0, -1}}; // 우,하,좌,상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 사과 위치
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        moveInfo = new HashMap<>();

        // 방향 변환
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int sec = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            moveInfo.put(sec, direction);
        }
        solution();
    }

    static void solution() {
        // 뱀 정보
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int sec = 0;
        
        int x = 0;
        int y = 0;

        while (true) {
            int nx = x + drc[0][d];
            int ny = y + drc[1][d];
            sec++;

            // 벽 부딪힘
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                break;
            }

            // 몸통 부딪힘
            if (q.contains(ny * N + nx)) {
                break;
            }

            // 안 부딪히면 뱀 이동시작
            if (map[ny][nx] == 1) { // 사과가 있을 경우
                map[ny][nx] = 0;
                q.add(ny * N + nx);
            } else {
                q.add(ny * N + nx);
                q.poll();   // 꼬리 삭제
            }

            // 해당 초에 방향 전환 정보가 있을 경우
            if (moveInfo.containsKey(sec)) {
                String data = moveInfo.get(sec);
                if (data.equals("D")) { // 오
                    d++;
                    if (d == 4) d = 0;
                } else {    // 왼
                    d--;
                    if (d == -1) d = 3;
                }
            }

            // 머리 갱신
            x = nx;
            y = ny;
        }
        System.out.println(sec);
    }
}