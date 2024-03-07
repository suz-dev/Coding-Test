import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int S, X, Y;

    static int[][] map;
    static int[][] drc = {{0,0,1,-1},{1,-1,0,0}};   // 각 virus 매 초마다 증식
    static PriorityQueue<int[]> pq;
    static PriorityQueue<int[]> tmpPQ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // map size
        K = Integer.parseInt(st.nextToken());   // 1 ~ K  virus number

        // num, r, c
        pq = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);

        map = new int[N+1][N+1];
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] > 0) pq.add(new int[]{map[r][c], r, c});
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());   // 진행 시간
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());


        while(S-- > 0){
            tmpPQ = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);

            while(!pq.isEmpty()){
                int[] now = pq.poll();
                bfs(now);
            }
            pq = tmpPQ;
        }
        System.out.println(map[X][Y]);
    }

    public static void bfs(int[] now){
        Queue<int[]> q = new LinkedList<>();

        // 1초에 한 level만 4방 탐색
        for(int d = 0; d < 4; d++){
            int nr = now[1] + drc[0][d];
            int nc = now[2] + drc[1][d];

            if(nr < 1 || nr > N || nc < 1 || nc > N || map[nr][nc] != 0) continue;

            map[nr][nc] = now[0];
            q.add(new int[]{now[0], nr, nc});
        }

        while(!q.isEmpty()) tmpPQ.add(q.poll());
    }
}