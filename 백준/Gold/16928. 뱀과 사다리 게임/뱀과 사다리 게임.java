import java.util.*;
import java.io.*;

// bfs 8방 : 1~6 + 뱀 + 사
public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int N, M, ans = 0;
    static Map<Integer, Integer> ladders, snakes;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 사다리수
        M = Integer.parseInt(st.nextToken());   // 뱀 수

        // 사다리 정보
        ladders = new HashMap<>();
        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladders.put(x, y);
        }

        // 뱀 정보
        snakes = new HashMap<>();
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            snakes.put(u, v);
        }

        board = new int[11][11];
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                board[i][j] = (i - 1) * 10 + j;
            }
        }

        visited = new boolean[11][11];
        bfs(1, 1);

        System.out.println(ans);
    }

    static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 1, 0});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int nowR = tmp[0];
            int nowC = tmp[1];
            int num = tmp[2];
            int cnt = tmp[3];

            if(num == 100) {
                ans = cnt;
                break;
            }

            // 주사위
            for(int n = 1; n <= 6; n++){
                int nNum = num + n;
                int nr = nNum / 10;
                int nc = nNum % 10;

                // 사다리 존재
                if(ladders.containsKey(nNum)){
                    nNum = ladders.get(nNum);
                    nr = nNum / 10;
                    nc = nNum % 10;
                }

                // 뱀 존재
                if(snakes.containsKey(nNum)){
                    nNum = snakes.get(nNum);
                    nr = nNum / 10;
                    nc = nNum % 10;
                }

                if(visited[nr][nc] || nNum > 100) continue;   // 범위 벗어날 일은 없음

                q.add(new int[]{nr, nc, nNum, cnt + 1});
                visited[nr][nc] = true;
            }
        }
    }
}