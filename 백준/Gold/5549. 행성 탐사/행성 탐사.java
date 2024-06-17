import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(br.readLine());

        int[][][] map = new int[N + 1][M + 1][3];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= M; j++) {
                for (int l = 0; l < 3; l++) {
                    map[i][j][l] = map[i][j - 1][l];
                }

                char tmp = str.charAt(j - 1);

                if (tmp == 'J') map[i][j][0]++;
                else if (tmp == 'O') map[i][j][1]++;
                else if (tmp == 'I') map[i][j][2]++;
            }

            for (int j = 1; j <= M; j++)
                for (int l = 0; l < 3; l++)
                    map[i][j][l] += map[i - 1][j][l];
        }

        int[] result = new int[3];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 3; i++) {
                result[i] = map[c][d][i] - map[a - 1][d][i] - map[c][b - 1][i] + map[a - 1][b - 1][i];
            }

            bw.write(result[0] + " " + result[1] + " " + result[2] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}