import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, minDis = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] open;
    static ArrayList<Node> stores = new ArrayList<>();
    static ArrayList<Node> customers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) customers.add(new Node(i, j));
                else if (map[i][j] == 2) stores.add(new Node(i, j));
            }
        }

        open = new boolean[stores.size()];
        dfs(0, 0);

        System.out.println(minDis);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < customers.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < stores.size(); j++) {
                    if (open[j]) {
                        int dis = Math.abs(customers.get(i).r - stores.get(j).r) + Math.abs(customers.get(i).c - stores.get(j).c);
                        tmp = Math.min(tmp, dis);
                    }
                }
                res += tmp;
            }
            minDis = Math.min(minDis, res);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    public static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}