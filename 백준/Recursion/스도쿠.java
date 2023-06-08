package 백준.boj_230608;

import java.io.*;

// 재귀
public class 스도쿠 {

    static int board[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = temp.charAt(j) - '0';
            }
        }

        sudoku(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void sudoku(int r, int c) {
        if (c == 9) {
            sudoku(r + 1, 0);   // 행 갱신
            return;
        } else if (r == 9) {    // 마지막 줄 끝났을 때 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0); // 시스템 종료 (안해주면 출력초과)
        }

        // 1~9 들어갈 수 있는 값 check
        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (boardCheck(r, c, i)) {  // 값 찾음
                    board[r][c] = i;
                    sudoku(r, c + 1);   // 열 갱신
                }
            }

            // 값 못찾음
            board[r][c] = 0;
            return;
        }
        sudoku(r, c + 1);   // 열 갱신
    }

    // 값 확인
    public static boolean boardCheck(int r, int c, int val) {
        //가로
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val) return false;
        }

        //세로
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == val) return false;
        }

        //3*3
        int startR = r / 3 * 3;
        int startC = c / 3 * 3;
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }
}
