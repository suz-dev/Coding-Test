import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, F;
    static int[][] map;

    static int tR, tC;  // 택시 위치
    static Map<Integer, int[]> desLoc = new HashMap<>();    // 목적지 위치

    static int[][] drc = {{0, -1, 0, 1}, {-1, 0, 1, 0}};    // 좌 상 우 하

    public static int solution(){

        int idx = 0;
        while(M-- > 0){
            // 1. 최단거리 승객 탐색
            // 승객 번호, 거리, 위치 - r, c, num, dis
            int[] nowCustomer = findCustomer(tR, tC);

            tR = nowCustomer[0];
            tC = nowCustomer[1];
            F -= nowCustomer[3];

            map[tR][tC] = 0;

            // 승객 못태움 || 연료 부족 check
            if(nowCustomer[2] == -1 || F <= 0){
                F = -1;
                break;
            }

            // 2. 도착지 까지 최단거리
            int dist = findShortestRoute(nowCustomer[2]);
            F -= dist;

            // 목적지 도착 X || 연료 부족 check
            if(dist == 0 || F < 0){
                F = -1;
                break;
            }

            int[] des = desLoc.get(nowCustomer[2]);
            tR = des[0];
            tC = des[1];
            F += dist * 2;

            desLoc.remove(nowCustomer[2]);
        }

        if(!desLoc.isEmpty()) return -1;
        return F;
    }

    public static int findShortestRoute(int num){
        Queue<int[]> q = new LinkedList<>();    // r, c, dist
        boolean[][] visited = new boolean[N][N];

        // 시작 위치
        q.add(new int[]{tR, tC, 0});
        visited[tR][tC] = true;

        // 도착 위치
        int[] dRC = desLoc.get(num);

        int dist = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();

            // 도착
            if(now[0] == dRC[0] && now[1] == dRC[1]){
                dist = now[2];
                break;
            }

            for(int d = 0; d < 4; d++){
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == -1) continue;

                q.add(new int[]{nr, nc, now[2] + 1});
                visited[nr][nc] = true;
            }
        }

        return dist;
    }

    public static int[] findCustomer(int r, int c){
        int[] customer = {r, c, -1, 0};  // 초기 상태

        // 택시 위치에 손님이 있을 때
        if(map[r][c] > 0) {
            customer[2] = map[r][c];
            return customer;
        }

        // 목적지
        // r, c, num, dis
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[3] == o2[3]) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
            return o1[3] - o2[3];
        });

        boolean[][] visited = new boolean[N][N];

        // r, c, dis
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0, 0});
        visited[r][c] = true;

        while(!q.isEmpty()){

            int[] now = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = now[0] + drc[0][d];
                int nc = now[1] + drc[1][d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == -1) continue;

                int[] next = new int[]{nr, nc, map[nr][nc], now[3] + 1};

                if(next[2] > 0) pq.add(next);   // 승객 위치

                q.add(next);
                visited[nr][nc] = true;
            }
        }

        if(!pq.isEmpty()) customer = pq.poll();   // 가장 가까운 승객
        return customer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());   // 최초 연료

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        tR = Integer.parseInt(st.nextToken()) - 1;
        tC = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int sR = Integer.parseInt(st.nextToken()) - 1;
            int sC = Integer.parseInt(st.nextToken()) - 1;

            int dR = Integer.parseInt(st.nextToken()) - 1;
            int dC = Integer.parseInt(st.nextToken()) - 1;

            map[sR][sC] = i;
            desLoc.put(i, new int[]{dR, dC});
        }

        System.out.println(solution());
    }
}