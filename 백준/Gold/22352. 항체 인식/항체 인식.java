import java.io.*;
import java.util.*;

public class Main {
    static int[][] drc = {{1,-1,0,0}, {0,0,-1,1}};  // 상 하 좌 우
    static int n, m, num;
    static int[][] beforeMap, afterMap;
    static int[][] visited;
    static int[][] flag; // 범위별 같은지 다른지 check - beforeMap 기준

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        beforeMap = new int[n][m];
        afterMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                beforeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                afterMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = 1;
        visited = new int[n][m];

        // afterMap 칸과 beforeMap 칸 비교 (다르다면 백신 투여 가능성 o)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                    num++;
                }
            }
        }

        flag = new int[num + 1][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = visited[i][j];
                // afterMap 값 넣기
                if(flag[k][1] == 0){
                    flag[k][0] = beforeMap[i][j];
                    flag[k][1] = afterMap[i][j];
                }

                if(flag[k][1] != 0 && flag[k][1] != afterMap[i][j]){
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= num; i++) {
            if (flag[i][0] != flag[i][1]) cnt++;
        }

        if(cnt > 1) System.out.println("NO");
        else System.out.println("YES");
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        visited[r][c] = num;
        int before = beforeMap[r][c];   // 기준

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] != 0 || beforeMap[nr][nc] != before) continue;

                // 값이 맞다면
                q.add(new int[]{nr, nc});
                visited[nr][nc] = num;
            }
        }
    }
}