import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;
    static final int[][] drc = {{0, 0, -1, 1}, {1, -1, 0, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        boolean flag = true;

        while (flag) {
            if (movePeople() == 0)
                flag = false;
            else
                ans++;
        }

        System.out.println(ans);
    }

    public static int movePeople() {
        int unionCnt = 0; // 연합체크

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                if (!visited[x][y]) {
                    Queue<Node> queue = new LinkedList<>();
                    Node node = new Node(x, y);
                    queue.add(node);

                    ArrayList<Node> list = new ArrayList<>();   // 연합 리스트
                    list.add(node);

                    visited[node.x][node.y] = true;

                    int unionSum = map[node.x][node.y]; // 인구 합계

                    while (!queue.isEmpty()) {
                        Node tmp = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = tmp.x + drc[0][d];
                            int ny = tmp.y + drc[1][d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!visited[nx][ny] && checkBoundary(tmp.x, tmp.y, nx, ny)) {
                                    queue.add(new Node(nx, ny));
                                    list.add(new Node(nx, ny));
                                    visited[nx][ny] = true;

                                    unionCnt++;
                                    unionSum += map[nx][ny];
                                }
                            }
                        }
                    }

                    // 인구 분배
                    if (unionCnt > 0) {   // 연합이 존재할 경우
                        int avg = unionSum / list.size();

                        for (int i = 0; i < list.size(); i++) {
                            Node current = list.get(i);
                            map[current.x][current.y] = avg;
                        }
                    }
                }
            }
        }

        // 방문배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        return unionCnt;
    }

    // 범위 체크
    public static boolean checkBoundary(int cx, int cy, int nx, int ny) {
        int sub = Math.abs(map[cx][cy] - map[nx][ny]);

        if (sub >= L && sub <= R)
            return true;

        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}