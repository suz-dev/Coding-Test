import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] wheels;
    static int[] checkRotation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new char[5][8];
        wheels[1] = br.readLine().toCharArray();
        wheels[2] = br.readLine().toCharArray();
        wheels[3] = br.readLine().toCharArray();
        wheels[4] = br.readLine().toCharArray();
        
        int K = Integer.parseInt(br.readLine());    // 회전 횟수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            // 회전하는 경우
            // 1~4 톱니바퀴 2번 6번 check
            checkRotation = new int[5];
            checkRotation[num] = dir;

            checkRight(num, dir);
            checkLeft(num, dir);

            for (int d = 1; d <= 4; d++) {
                rotation(d, checkRotation[d]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= 4; i++) {
            if (wheels[i][0] == '1') {
                ans += Math.pow(2, i - 1);
            }
        }
        System.out.println(ans);
    }

    // 같은 극 확인
    public static void checkRight(int num, int dir) {
        if (num == 4) {
            return;
        }

        if (wheels[num][2] != wheels[num + 1][6]) {
            checkRotation[num + 1] = dir * (-1);
            checkRight(num + 1, checkRotation[num + 1]);
        }
    }

    public static void checkLeft(int num, int dir) {
        if (num == 1) {
            return;
        }

        if (wheels[num][6] != wheels[num - 1][2]) {
            checkRotation[num - 1] = dir * (-1);
            checkLeft(num - 1, checkRotation[num - 1]);
        }
    }

    public static void rotation(int num, int dir) {
        if (dir == 0) return;

        char tmp;

        // 시계
        if (dir == 1) {
            tmp = wheels[num][7];
            for (int i = 7; i > 0; i--) {
                wheels[num][i] = wheels[num][i - 1];
            }
            wheels[num][0] = tmp;
        } else {    // 반시계
            tmp = wheels[num][0];
            for (int i = 1; i < 8; i++) {
                wheels[num][i - 1] = wheels[num][i];
            }
            wheels[num][7] = tmp;
        }
    }
}