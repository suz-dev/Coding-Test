import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        isSelected = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int cnt) {
        if (cnt == N / 2) {
            calculation();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                dfs(i + 1, cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    public static void calculation() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isSelected[i] && isSelected[j]) teamStart += (map[i][j] + map[j][i]);
                if (!isSelected[i] && !isSelected[j]) teamLink += (map[i][j] + map[j][i]);
            }
        }

        int sum = Math.abs(teamStart - teamLink);
        if(sum == 0){
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, sum);
    }
}