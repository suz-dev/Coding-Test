import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] drc = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static ArrayList<int[]> list = new ArrayList<>();

    public static int solution(){
        int answer = Integer.MAX_VALUE;

        // 1. 섬 구별
        int num = 1;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(map[r][c] == 1) {
                    checkIsland(++num, r, c);
                }
            }
        }

        for(int i = 0; i < list.size() - 1; i++){
            int[] pre = list.get(i);
            for(int j = i + 1; j < list.size(); j++){
                int[] now = list.get(j);

                if(pre[2] != now[2]){
                    int dist = Math.abs(pre[0] - now[0]) + Math.abs(pre[1] - now[1]) - 1;
                    answer = Math.min(answer, dist);
                }
            }
        }

        return answer;
    }

    public static void checkIsland(int num, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        map[r][c] = num;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            list.add(new int[]{tmp[0], tmp[1], num});

            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 1) continue;

                map[nr][nc] = num;
                q.add(new int[]{nr, nc});
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(solution());
    }
}