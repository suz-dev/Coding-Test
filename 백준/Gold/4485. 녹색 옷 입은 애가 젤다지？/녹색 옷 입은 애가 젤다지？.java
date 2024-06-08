import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map, dist;
    static boolean[][] visited;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 0;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            map = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
            dijkstra();

            System.out.println("Problem " + ++cnt + ": " + dist[N - 1][N - 1]);

        }
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(0,0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()){
            Node now = pq.poll();

            for(int d = 0; d < 4; d++){
                int nr = now.r + drc[0][d];
                int nc = now.c + drc[1][d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if(map[nr][nc] + now.cost < dist[nr][nc]) {
                    dist[nr][nc] = map[nr][nc] + now.cost;
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
    }

    static class Node{
        int r, c, cost;

        public Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;

        }
    }
}