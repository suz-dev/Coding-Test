import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        int[][] minDP = new int[N][3];
        int[][] maxDP = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0) minDP[i][j] = maxDP[i][j] = arr[i][j];
            }
        }

        for (int r = 1; r < N; r++) {
            maxDP[r][0] = arr[r][0] + Math.max(maxDP[r - 1][0], maxDP[r - 1][1]);
            maxDP[r][1] = arr[r][1] + Math.max(maxDP[r - 1][0], Math.max(maxDP[r - 1][1], maxDP[r - 1][2]));
            maxDP[r][2] = arr[r][2] + Math.max(maxDP[r - 1][1], maxDP[r - 1][2]);

            minDP[r][0] = arr[r][0] + Math.min(minDP[r - 1][0], minDP[r - 1][1]);
            minDP[r][1] = arr[r][1] + Math.min(minDP[r - 1][0], Math.min(minDP[r - 1][1], minDP[r - 1][2]));
            minDP[r][2] = arr[r][2] + Math.min(minDP[r - 1][1], minDP[r - 1][2]);
        }

        bw.write(Math.max(maxDP[N - 1][0], Math.max(maxDP[N - 1][1], maxDP[N - 1][2])) + " ");
        bw.write(Math.min(minDP[N - 1][0], Math.min(minDP[N-1][1], minDP[N - 1][2])) + "");

        bw.flush();
        bw.close();
    }
}