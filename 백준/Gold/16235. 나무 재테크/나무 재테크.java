import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A, map;
    static int[][] drc = {{-1, -1, -1, 0, 0, 1, 1, 1}, {-1, 0, 1, -1, 1, -1, 0, 1}}; // 8방 탐색
    static Deque<Tree> tree_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        A = new int[N][N];  // 양분정보

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        tree_list = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());   //  나이

            tree_list.add(new Tree(r, c, age));
        }

        while (K-- > 0) {
            Queue<Tree> die_tree = new LinkedList<>();

            for (int i = 0; i < tree_list.size(); i++) {
                Tree tree = tree_list.poll();
                if (map[tree.r][tree.c] < tree.age) {
                    die_tree.add(tree);
                    i--;
                } else {
                    map[tree.r][tree.c] -= tree.age;
                    tree_list.add(new Tree(tree.r, tree.c, tree.age + 1));
                }
            }

            for(Tree tree : die_tree) summer(tree);

            autumn();
            winter();
        }

        System.out.println(tree_list.size());
    }
    public static void summer(Tree tree) {
        map[tree.r][tree.c] += (tree.age / 2);
    }
    
    public static void autumn() {
        Queue<Tree> tmpQ = new LinkedList<>();
        for (Tree tree : tree_list) {
            if (tree.age % 5 == 0) tmpQ.add(tree);
        }
        while (!tmpQ.isEmpty()) {
            Tree tree = tmpQ.poll();

            for (int d = 0; d < 8; d++) {
                int nr = tree.r + drc[0][d];
                int nc = tree.c + drc[1][d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                tree_list.addFirst(new Tree(nr, nc, 1));    //  나이어린 나무부터 탐색
            }
        }
    }
    
    public static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static class Tree {
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "r=" + r +
                    ", c=" + c +
                    ", age=" + age +
                    '}';
        }
    }
}