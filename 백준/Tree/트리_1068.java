package 백준.boj_230629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_1068 {
    static int N, removeNum, result;
    static boolean[][] parentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parentTree = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == -1) start = i;
            else parentTree[value][i] = true;
        }

        removeNum = Integer.parseInt(br.readLine());
        result = 0;
        if (start != removeNum) dfs(start);
        System.out.println(result);
    }

    public static void dfs(int idx) {
        boolean check = false;
        for (int i = 0; i < N; i++) {
            if (!parentTree[idx][i] || i == removeNum) continue;
            check = true;
            dfs(i);
        }
        if (!check) result++;
    }
}
