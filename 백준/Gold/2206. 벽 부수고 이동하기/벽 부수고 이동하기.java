import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];

        int ans = bfs(0,0);
        System.out.println(ans);

    }

    public static int bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0, 1});  // 시작 위치, 부순 벽, 거리
        visited[r][c][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0] == N - 1 && now[1] == M - 1) return now[3];

            for(int d = 0; d < 4; d++){
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][now[2]]) continue;

                if(map[nr][nc] == 0) {
                    q.add(new int[]{nr, nc, now[2], now[3] + 1});
                    visited[nr][nc][now[2]] = true;
                } else if(now[2] == 0) {
                    q.add(new int[]{nr, nc, 1, now[3] + 1});
                    visited[nr][nc][1] = true;
                }
            }
        }

        return -1;
    }
}