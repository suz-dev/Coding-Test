import java.util.*;
import java.io.*;

// 감시 dfs
public class Main {
    static int N, M, area = 0, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] drc = {{-1, 0, 1, 0}, {0, 1, 0, -1}};    // 상 우 하 좌 - 0,1,2,3
    static Map<Integer, String[]> cctvDir = new HashMap<>();    // cctv 별 감시 방향
    static ArrayList<int[]> cctvPos = new ArrayList<>();    // cctv 위치

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // cctv 별 감시 가능영역 check
        int[][] detectedArea = new int[N][M];
        map = new int[N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());

                // 0: 칸 / 6: 벽 / 1~5: cctv 종류
                if(map[r][c] == 6) continue;
                else if(map[r][c] == 0) area++;  // 감시 가능 영역
                else {
                    cctvPos.add(new int[]{map[r][c], r, c}); // cctv 정보
                    detectedArea[r][c] = -1;
                }

                // cctv 2~4
                if(map[r][c] == 2) cctvDir.put(2, new String[]{"02", "13"});
                if (map[r][c] == 3) cctvDir.put(3, new String[]{"01", "12", "23", "30"});
                if(map[r][c] == 4) cctvDir.put(4, new String[]{"012", "123", "230", "301"});
            }
        }

        // 정렬 (cctv 종류 내림차순)
        Collections.sort(cctvPos, (o1,o2)-> o2[0] - o1[0]);
        LinkedList<String> detectList = new LinkedList<>();

        dfs(0, detectedArea, detectList);
        System.out.println(min);
    }

    static void dfs(int idx, int[][] detectedArea, LinkedList<String> detectList){
        // 마지막 idx
        if(idx == cctvPos.size()){
            int detCnt = 0;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    if(detectedArea[r][c] > 0) detCnt++;
                }
            }

            min = Math.min(min, (area - detCnt));
            return;
        }

        int size = detectList.size();
        int[] tmp = cctvPos.get(idx);

        int cctv = tmp[0];
        int r = tmp[1];
        int c = tmp[2];

        // 5
        if(cctv == 5){
            for (int d = 0; d < 4; d++){
                int cnt = 0;
                int nr = r;
                int nc = c;

                while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    cnt++;
                    nr = r + drc[0][d] * cnt;
                    nc = c + drc[1][d] * cnt;

                    // 범위 벗어남 || 벽
                    if(nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || map[nr][nc] == 6) break;
                    if(detectedArea[nr][nc] < 0) continue;

                    detectedArea[nr][nc]++;    // 감시 영역
                    String pos = nr + "" + nc;
                    detectList.add(pos);
                }
            }

            dfs(idx + 1, detectedArea, detectList);

            while(detectList.size() > size) {
                String str = detectList.getLast();
                detectList.removeLast();

                detectedArea[str.charAt(0) - '0'][str.charAt(1) - '0']--;
            }
        }

        // 4 ~ 2
        if(cctv > 1 && cctv < 5){
            String[] dirs = cctvDir.get(cctv);

            for(int n = 0; n < dirs.length; n++){
                char[] nowDir = dirs[n].toCharArray();

                for(int d = 0; d < nowDir.length; d++){
                    int dir = nowDir[d] - '0';

                    int cnt = 0;
                    int nr = r;
                    int nc = c;

                    while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        ++cnt;

                        nr = r + drc[0][dir] * cnt;
                        nc = c + drc[1][dir] * cnt;

                        if(nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || map[nr][nc] == 6) break;
                        if(detectedArea[nr][nc] < 0) continue;

                        detectedArea[nr][nc]++;    // 감시 영역
                        String pos = nr + "" + nc;
                        detectList.add(pos);
                    }
                }

                dfs(idx+1, detectedArea, detectList);

                while(detectList.size() > size) {
                    String str = detectList.getLast();
                    detectList.removeLast();

                    detectedArea[str.charAt(0) - '0'][str.charAt(1) - '0']--;
                }
            }
        }

        // 1
        if(cctv == 1){
            for (int d = 0; d < 4; d++){

                int cnt = 0;
                int nr = r;
                int nc = c;

                while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    ++cnt;

                    nr = r + drc[0][d] * cnt;
                    nc = c + drc[1][d] * cnt;

                    if(nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || map[nr][nc] == 6) break;
                    if(detectedArea[nr][nc] < 0) continue;

                    detectedArea[nr][nc]++;    // 감시 영역
                    String pos = nr + "" + nc;
                    detectList.add(pos);
                }

                // 한 방향씩만
                dfs(idx + 1, detectedArea,detectList);

                // 원상복귀
                while(detectList.size() > size) {
                    String str = detectList.getLast();
                    detectList.removeLast();
                    detectedArea[str.charAt(0) - '0'][str.charAt(1) - '0']--;
                }
            }
        }
    }
}