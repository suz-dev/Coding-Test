import java.util.*;
import java.io.*;

public class Main {

    static int R, C, cheese, time = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static Queue<int[]> cheeseQ = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =  0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 초기 개수
                if(map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        while (true){
            // 공기 판별
            visited = new boolean[R][C];
            bfs(0, 0);

            // 치즈 제거
            int cnt = cheeseQ.size();
            while(!cheeseQ.isEmpty()){
                int[] now = cheeseQ.poll();
                map[now[0]][now[1]] = 0;
            }

            time++;
            if(cheese - cnt == 0) break;

            cheese -= cnt;
        }

        System.out.println(time + "\n" + cheese);
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) continue;

                if(map[nr][nc] == 1) {
                    cheeseQ.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    continue;
                }

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}