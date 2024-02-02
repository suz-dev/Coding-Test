import java.util.*;
import java.io.*;

public class Main {

    static int N, M, cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    public static void main(String args[])  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                // 행성 연결 처리
                if(nr < 0) nr += N;
                if(nc < 0) nc += M;
                if(nr >= N) nr -= N;
                if(nc >= M) nc -= M;

                if(visited[nr][nc] || map[nr][nc] == 1) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}