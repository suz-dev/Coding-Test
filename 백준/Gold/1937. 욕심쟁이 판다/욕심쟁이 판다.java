import java.util.*;
import java.io.*;

public class Main {
    static int N, max = 0;
    static int[][] map, dp;
    static int[][] drc = {{0,0,1,-1}, {1,-1,0,0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);
    }

    public static int dfs(int r, int c){
        if(dp[r][c] != 0) return dp[r][c];

        dp[r][c] = 1;

        int nr, nc;
        for(int d = 0; d < 4; d++){
            nr = r + drc[0][d];
            nc = c + drc[1][d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            if(map[r][c] < map[nr][nc]){
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
                dfs(nr, nc);
            }
        }

        return dp[r][c];
    }
}