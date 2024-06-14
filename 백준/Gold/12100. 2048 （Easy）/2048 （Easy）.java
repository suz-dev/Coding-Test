import java.util.*;
import java.io.*;

public class Main {

    static int N, max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs
        dfs(0, map);
        System.out.println(max);
    }

    public static void dfs(int cnt, int[][] nowMap){
        if(cnt == 5) return;

        for(int d = 0; d < 4; d++){
            int[][] newMap = move(d, nowMap);

            dfs(cnt + 1, newMap);
        }
    }

    public static int[][] move(int dir, int[][] nowMap){
        int[][] newMap = new int[N][N];

        // 상좌하우
        if(dir == 0){
            for(int j = 0; j < N; j++){
                Queue<Integer> q = new LinkedList<>();
                for(int i = 0; i < N; i++){
                    if(nowMap[i][j] != 0) q.add(nowMap[i][j]);
                }

                int idx = 0;
                while (!q.isEmpty()){
                    newMap[idx++][j] = q.poll();
                }

                // 합치기
                for(int i = 1; i < N; i++){
                    if(newMap[i][j] == 0) break;

                    if(newMap[i][j] == newMap[i - 1][j]) {
                        newMap[i - 1][j] += newMap[i][j];
                        newMap[i][j] = 0;
                    }
                }

                for(int i = 0; i < N; i++){
                    if(newMap[i][j] != 0) {
                        max = Math.max(max, newMap[i][j]);
                        q.add(newMap[i][j]);
                        newMap[i][j] = 0;
                    }
                }

                idx = 0;
                while (!q.isEmpty()){
                    newMap[idx++][j] = q.poll();
                }
            }
        }

        if(dir == 1){
            for(int i = 0; i < N; i++){
                Queue<Integer> q = new LinkedList<>();
                for(int j = 0; j < N; j++){
                    if(nowMap[i][j] != 0) q.add(nowMap[i][j]);
                }

                int idx = 0;
                while (!q.isEmpty()){
                    newMap[i][idx++] = q.poll();
                }

                // 합치기
                for(int j = 1; j < N; j++){
                    if(newMap[i][j] == 0) break;

                    if(newMap[i][j] == newMap[i][j - 1]) {
                        newMap[i][j - 1] += newMap[i][j];
                        newMap[i][j] = 0;
                    }
                }

                for(int j = 0; j < N; j++){
                    if(newMap[i][j] != 0) {
                        max = Math.max(max, newMap[i][j]);
                        q.add(newMap[i][j]);
                        newMap[i][j] = 0;
                    }
                }

                idx = 0;
                while (!q.isEmpty()){
                    newMap[i][idx++] = q.poll();
                }
            }
        }

        if(dir == 2){
            for(int j = 0; j < N; j++){
                Queue<Integer> q = new LinkedList<>();
                for(int i = N - 1; i >= 0; i--){
                    if(nowMap[i][j] != 0) q.add(nowMap[i][j]);
                }

                int idx = N - 1;
                while (!q.isEmpty()){
                    newMap[idx--][j] = q.poll();
                }

                // 합치기
                for(int i = N - 2; i >= 0; i--){
                    if(newMap[i][j] == 0) break;

                    if(newMap[i][j] == newMap[i + 1][j]) {
                        newMap[i + 1][j] += newMap[i][j];
                        newMap[i][j] = 0;
                    }
                }

                for(int i = N - 1; i >= 0; i--){
                    if(newMap[i][j] != 0) {
                        max = Math.max(max, newMap[i][j]);
                        q.add(newMap[i][j]);
                        newMap[i][j] = 0;
                    }
                }

                idx = N - 1;
                while (!q.isEmpty()){
                    newMap[idx--][j] = q.poll();
                }
            }
        }

        if(dir == 3){
            for(int i = 0; i < N; i++){
                Queue<Integer> q = new LinkedList<>();
                for(int j = N - 1; j >= 0; j--){
                    if(nowMap[i][j] != 0) q.add(nowMap[i][j]);
                }

                int idx = N - 1;
                while (!q.isEmpty()){
                    newMap[i][idx--] = q.poll();
                }

                // 합치기
                for(int j = N - 2; j >= 0; j--){
                    if(newMap[i][j] == 0) break;

                    if(newMap[i][j] == newMap[i][j + 1]) {
                        newMap[i][j + 1] += newMap[i][j];
                        newMap[i][j] = 0;
                    }
                }

                // 갱신
                for(int j = N - 1; j >= 0; j--){
                    if(newMap[i][j] != 0) {
                        max = Math.max(max, newMap[i][j]);
                        q.add(newMap[i][j]);
                        newMap[i][j] = 0;
                    }
                }

                idx = N - 1;
                while (!q.isEmpty()){
                    newMap[i][idx--] = q.poll();
                }
            }
        }

        return newMap;
    }
}