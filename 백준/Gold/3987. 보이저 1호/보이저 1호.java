import java.util.*;
import java.io.*;

public class Main {
    static int N, M, max = 0, dir = -1;
    static char[][] map;
    static int[][] visited;
    static int[][] drc = {{0, 1, 0, -1}, {-1, 0, 1, 0}};    // 좌하우상
    static Map<Integer, Integer> left = new HashMap<>();
    static Map<Integer, Integer> right = new HashMap<>();
    static char[] direction = {'L', 'D', 'R', 'U'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        left.put(0, 3);
        left.put(3, 0);
        left.put(1, 2);
        left.put(2, 1);

        right.put(0, 1);
        right.put(1, 0);
        right.put(3, 2);
        right.put(2, 3);


        st = new StringTokenizer(br.readLine());
        int PR = Integer.parseInt(st.nextToken()) - 1;
        int PC = Integer.parseInt(st.nextToken()) - 1;

        for(int d = 0; d < 4; d++){
            // 초기화
            visited = new int[N][M];
            for(int i = 0; i < N; i++) Arrays.fill(visited[i], -1);

            int cnt = bfs(PR, PC, d);
            if(cnt >= max){
                max = cnt;
                dir = d;
            }
        }

        System.out.println(direction[dir]);
        if(max == Integer.MAX_VALUE) System.out.println("Voyager");
        else System.out.println(max);
    }

    public static int bfs(int r, int c, int dir){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, dir});
        visited[r][c] = dir;

        int cnt = 0;    // 이동에 걸리는 시간
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int nr = tmp[0];
            int nc = tmp[1];
            int d = tmp[2];

            int k = 0;
            while(nr >= 0 && nr < N && nc >= 0 && nc < M){
                ++k;
                nr = tmp[0] + drc[0][d] * k;
                nc = tmp[1] + drc[1][d] * k;

                cnt++;

                // 범위 초과 || 블랙홀
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'C'){
                    return cnt;
                }

                // 무한 돌기
                if(visited[nr][nc] == d){
                    return Integer.MAX_VALUE;
                }

                int nd = d;
                // 방향 변경
                if(map[nr][nc] == '/'){     // right
                    nd = right.get(d);
                    q.add(new int[]{nr, nc, nd});
                    visited[nr][nc] = nd;

                    break;
                }

                if(map[nr][nc] == '\\'){    // left
                    nd = left.get(d);
                    q.add(new int[]{nr, nc, nd});
                    visited[nr][nc] = nd;

                    break;
                }

                visited[nr][nc] = nd;
            }
        }
        return cnt;
    }
}