import java.util.*;

class Solution {
    
    static final int N = 101;
    static int[][] map;
    static boolean[][] visited;
    static int[][] drc = {{0,0,1,-1}, {1,-1,0,0}};
    static int answer;
    
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;

        map = new int[N][N];
        for (int[] rec : rectangle) {
            int leftC = rec[0] * 2;
            int leftR = rec[1] * 2;
            int rightC = rec[2] * 2;
            int rightR = rec[3] * 2;

            for (int r = leftR; r <= rightR; r++) {
                for (int c = leftC; c <= rightC; c++) {
                    
                    if(map[r][c] == 1) continue;
                    
                    map[r][c] = 1;
                    if(r == leftR || r == rightR || c == leftC || c == rightC) map[r][c] = 2;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if (map[r][c] == 1) {

                    for (int d = 0; d < 4; d++) {
                        int nr = r + drc[0][d];
                        int nc = c + drc[1][d];

                        if (map[nr][nc] == 0) {
                            map[r][c] = 2;
                            break;
                        }
                    }
                }
            }
        }

        map[itemY * 2][itemX * 2] = 3;
        visited = new boolean[N][N];

        bfs(characterY * 2, characterX * 2);

        return answer / 2;
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (map[tmp[0]][tmp[1]] == 3) {
                answer = tmp[2];
                return;
            }

            int cnt = 0;

            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] < 2) continue;
                
                q.add(new int[]{nr, nc, tmp[2] + 1});
                visited[nr][nc] = true;
                
            }
        }
    }
}
