import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer = 0;
    static int[][] map;
    static boolean[][] visited;
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
            }
        }

        visited = new boolean[N][M];

        // 낮은 숫자부터 탐색
        for (int k = 1; k <= 9; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == k && !visited[i][j]) {
                        bfs(i, j, k);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int r, int c, int num){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{r, c});

        int min = 10;
        boolean flag = false;    // 벽 외부
        while (!q.isEmpty()){
            int[] now = q.poll();

            // 테두리
            if(now[0] == 0 || now[0] == N - 1 || now[1] == 0 || now[1] == M - 1) flag = true;

            for(int d = 0; d < 4; d++){
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                // 범위 벗어남
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(map[nr][nc] == num && !visited[nr][nc]){
                    list.add(new int[]{nr, nc});
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

                // 벽 존재
                if(map[nr][nc] > num) min = Math.min(min, map[nr][nc]);

                // 내부 - 더 낮은 공간 존재
                if(map[nr][nc] < num) flag = true;
            }
        }

        // 물 채우기
        if(!flag){
            answer += list.size() * (min - num);
            for (int[] now : list){
                map[now[0]][now[1]] = min;
                visited[now[0]][now[1]] = false;    // bfs 추가 탐색 할 수 있음
            }
        }
    }
}