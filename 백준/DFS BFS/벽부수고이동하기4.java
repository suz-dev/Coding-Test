package 백준.boj_230606;

import java.io.*;
import java.util.*;

// 벽 부수고 그 자리 포함
public class 벽부수고이동하기4 {

    static int N, M;
    static int[][] map;
    static int[][] answer;
    static int[][] drc = {{1, -1, 0, 0}, {0, 0, 1, -1}};

    static Map<Integer, Integer> hashMap = new HashMap<>();

    static class Node {
        int r;
        int c;

        public Node(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 인접 영역 그룹화
        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    hashMap.put(num, bfs(i, j, num));
                    num++;
                }
            }
        }

        // 4방탐색 (그룹 check)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    answer[i][j] = 1;

                    // 중복그룹 제거
                    Set<Integer> set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int nr = i + drc[0][d];
                        int nc = j + drc[1][d];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 1) {
                            set.add(map[nr][nc]);
                        }
                    }

                    for (int a : set) {
                        answer[i][j] += hashMap.get(a);
                    }
                }
            }
        }

        // 정답 배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(answer[i][j] % 10 + "");
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

    // 영역 묶기
    public static int bfs(int r, int c, int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        map[r][c] = num;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node.r + drc[0][d];
                int nc = node.c + drc[1][d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    map[nr][nc] = num;
                    queue.add(new Node(nr, nc));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}