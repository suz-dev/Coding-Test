import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static ArrayList<Fireball> map[][];
    static ArrayList<Fireball> list = new ArrayList<>();    // 전체 fireball
    static int[][] drc = {{-1, -1, 0, 1, 1, 1, 0, -1}, {0, 1, 1, 1, 0, -1, -1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<Fireball>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Fireball(r, c, m, s, d));
            list.add(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            move(); // 이동

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 같은 좌표에 fireball 여러개 있을 경우
                    if (map[i][j].size() >= 2) {
                        merge(i, j);
                    }
                }
            }

            makeList();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball cur : map[i][j]) {
                        ans += cur.m;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    // 현재 전체 fireball 정보
    public static void makeList() {
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball cur : map[i][j]) {
                        list.add(cur);
                    }
                }
            }
        }
    }

    // fireball 이동
    public static void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<Fireball>();
            }
        }

        for (Fireball cur : list) {
            cur.r = (cur.r + N + drc[0][cur.d] * (cur.s % N)) % N;
            cur.c = (cur.c + N + drc[1][cur.d] * (cur.s % N)) % N;

            map[cur.r][cur.c].add(cur);
        }
    }

    // fireball 병합
    public static void merge(int r, int c) {
        int sumM = 0, sumS = 0;
        boolean isEven = true;
        boolean isOdd = true;

        for (Fireball cur : map[r][c]) {
            sumM += cur.m;
            sumS += cur.s;

            if (cur.d % 2 == 0) {
                isOdd = false;
            } else {
                isEven = false;
            }
        }

        int M = sumM / 5;
        int S = sumS / map[r][c].size();

        map[r][c] = new ArrayList<>();
        if (M <= 0) {
            return;
        }

        if (isEven || isOdd) {
            for (int i = 0; i < 4; i++) {
                map[r][c].add(new Fireball(r, c, M, S, i * 2));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                map[r][c].add(new Fireball(r, c, M, S, i * 2 + 1));
            }
        }
    }

    public static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}