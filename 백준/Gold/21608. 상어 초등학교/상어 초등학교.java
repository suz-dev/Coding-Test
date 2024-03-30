import java.util.*;
import java.io.*;

public class Main {

    static int N, ans = 0;
    static int[][] map;
    static int[][] drc = {{-1,1,0,0}, {0,0,-1,1}};  // 상 좌 우 하
    static Map<Integer, ArrayList<Integer>> studentInfo = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();
    static int[] satisfactionScore = {0,1,10,100,1000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());

            // 한번에 어떻게 넣지?
            ArrayList<Integer> list = new ArrayList<>();
            list.add(f1);
            list.add(f2);
            list.add(f3);
            list.add(f4);

            studentInfo.put(num, list);
            q.add(num);
        }

        // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        bfs();

        // 만족도 계산
        calSatisfaction();

        System.out.println(ans);
    }

    public static void calSatisfaction(){
        for (int r = 0; r < N; r++){
            for(int c = 0; c < N; c++) {
                int num = map[r][c];
                int favCnt = 0;

                ArrayList<Integer> favList = studentInfo.get(num);
                for(int d = 0; d < 4; d++){
                    int nr = r + drc[0][d];
                    int nc = c + drc[1][d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(favList.contains(map[nr][nc])) favCnt++;
                }
                ans += satisfactionScore[favCnt];
            }
        }
    }

    public static void bfs(){
        // 전체 학생에 대해 빈칸 탐색
        while(!q.isEmpty()){
            int now = q.poll();

            // favCnt, blankCnt, r, c
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            });

            // 좋아하는 학생 list
            ArrayList favList = studentInfo.get(now);

            // 빈칸 탐색
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(map[r][c] != 0) continue;

                    int favCnt = 0;
                    int blankCnt = 0;

                    for(int d = 0; d < 4; d++){
                        int nr = r + drc[0][d];
                        int nc = c + drc[1][d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                        // 1번 수행: 좋아하는 학생 찾기
                        if(favList.contains(map[nr][nc])) favCnt++;
                        // 2번 수행: 빈칸 찾기
                        if (map[nr][nc] == 0) blankCnt++;
                    }

                    pq.add(new int[]{favCnt, blankCnt, r, c});
                }
            }

            int[] pos = pq.poll();
            map[pos[2]][pos[3]] = now;
        }
    }
}