import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 공통부분 문자열
public class Main {
    static int[][] drc = {{1, -1, 0 , 0}, {0, 0, 1, -1}};
    static boolean[][] visited = new boolean[12][6];

    public static int solution(int[][] board) {
        int answer = 0;

        // 연쇄 현재
        // 재배치 후 연쇄

        ArrayList<int[]> list;
        while(true){
            list = new ArrayList<>();
            // 게임 턴
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    // 연쇄 check
                    if(board[i][j] == 0) continue;
                    if(bfs(i, j, board)) list.add(new int[]{i, j});
                }
            }

            // 종료 조건
            if(list.size() == 0) break;

            answer++;
            // 연쇄 됐다면 갱신
            updateBoard(board);
            // 방문배열 갱신
            visited = new boolean[12][6];
        }

        return answer;
    }

    // 갱신
    static int[][] updateBoard(int[][] board){
        // 뿌요 터뜨리기
        for(int r = 0; r < 12; r++){
            for(int c = 0; c < 6; c++){
                if(!visited[r][c]) continue;
                board[r][c] = 0;
            }
        }

        // board 갱신
        for(int c = 0; c < 6; c++){
            Queue<Integer> q = new LinkedList<>();
            int startIdx = 12;

            for(int r = 11; r >= 0; r--){
                if(startIdx == 12 && board[r][c] == 0) startIdx = r;  // 시작점 갱신
                else if(startIdx < 12 && board[r][c] > 0) {
                    q.add(board[r][c]);
                    board[r][c] = 0;
                }
            }

            while(!q.isEmpty()) {
                board[startIdx--][c] = q.poll();
            }
        }

        return board;
    }

    // 연쇄 check -> 4개 이상이어야 함
    // 4개 이상인지 check
    static boolean bfs(int r, int c, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        boolean[][] tmpVisited = new boolean[12][6];

        int cnt = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = tmp[0] + drc[0][d];
                int nc = tmp[1] + drc[1][d];

                if(nr < 0 || nr > 11 || nc < 0 || nc > 5 || tmpVisited[nr][nc] || board[nr][nc] != board[tmp[0]][tmp[1]]) continue;

                q.add(new int[]{nr, nc});
                tmpVisited[nr][nc] = true;
                cnt++;
            }
        }

        if(cnt < 4) return false;

        // 방문 병합
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                if(tmpVisited[i][j]) visited[i][j] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int[][] board = new int[12][6];
        for(int i = 0; i < 12; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < 6; j++){
                if(tmp[j] != '.') board[i][j] = tmp[j] - 'A';
            }
        }

        System.out.println(solution(board));
    }
}