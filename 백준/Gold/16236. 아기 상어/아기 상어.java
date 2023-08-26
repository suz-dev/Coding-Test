import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int drc[][] = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    q.add(new Node(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        int babySharkSize = 2;
        int ans = 0;
        int eatCnt = 0;

        while (true) {
            int[][] dist = new int[N][N];   // 이동거리 기록 (시간)
            // 먹은고기 (우선순위 정렬)
            PriorityQueue<Node> eatFish = new PriorityQueue<>((o1, o2) -> {
                if (o1.dist == o2.dist) {
                    if (o1.r == o2.r) return o1.c - o2.c;
                    else return o1.r - o2.r;
                }
                return o1.dist - o2.dist;
            });

            while (!q.isEmpty()) {
                Node tmp = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = tmp.r + drc[0][d];
                    int nc = tmp.c + drc[1][d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    if (dist[nr][nc] == 0 && map[nr][nc] <= babySharkSize) {
                        dist[nr][nc] = dist[tmp.r][tmp.c] + 1;
                        q.add(new Node(nr, nc, dist[nr][nc]));

                        if (1 <= map[nr][nc] && map[nr][nc] < babySharkSize) {   // 먹을 수 있는 고기
                            eatFish.add(new Node(nr, nc, dist[nr][nc]));
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기 X
            if (eatFish.size() == 0) {
                System.out.println(ans);
                return;
            }

            // 고기 먹기
            Node nowFish = eatFish.poll();
            map[nowFish.r][nowFish.c] = 0;
            ans += nowFish.dist;
            eatCnt++;

            // 상어 크기 갱신
            if (babySharkSize == eatCnt) {
                babySharkSize++;
                eatCnt = 0;
            }

            // 새 좌표 추가
            q.add(nowFish);
        }
    }

    static class Node {
        int r, c, dist;

        Node(int x, int y, int dist) {
            this.r = x;
            this.c = y;
            this.dist = dist;
        }
    }
}