import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N * 2];
        boolean[] robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        while (true) {
            ans++;

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int tmp = belt[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }

            robots[0] = false;
            robots[N - 1] = false;   // 내리기

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = N - 1; i > 0; i--) {
                if (robots[i - 1] && !robots[i] && belt[i] > 0) {
                    robots[i - 1] = false;
                    robots[i] = true;
                    belt[i]--;

                    robots[N - 1] = false;
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt = 0;
            for (int i = 0; i < N * 2; i++) {
                if (belt[i] == 0) cnt++;
            }

            if (cnt >= K) break;
        }

        System.out.println(ans);
    }
}