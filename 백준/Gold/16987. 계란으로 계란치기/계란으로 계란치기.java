import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxCnt;
    static int[][] eggs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2]; // 내구도, 무게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        maxCnt = 0;
        dfs(0, 0);
        System.out.println(maxCnt);
    }

    private static void dfs(int nowIdx, int breakCnt) {
        maxCnt = Math.max(maxCnt, breakCnt);  // 최대값 갱신

        if (nowIdx == N) return; // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란
        if (eggs[nowIdx][0] <= 0) dfs(nowIdx + 1, breakCnt); // 손에 든 계란이 깨진 경우
        else {
            for (int next = 0; next < N; next++) {
                if (next == nowIdx || eggs[next][0] <= 0) continue; // 제외 조건 (손에 든 계란 or 이미 깨진 계란)

                // 계란 치기
                eggs[nowIdx][0] -= eggs[next][1];
                eggs[next][0] -= eggs[nowIdx][1];

                // 깨진 계란 개수 count
                int newBreakCnt = breakCnt;
                if (eggs[nowIdx][0] <= 0) newBreakCnt++;
                if (eggs[next][0] <= 0) newBreakCnt++;

                dfs(nowIdx + 1, newBreakCnt);

                // 복구
                eggs[nowIdx][0] += eggs[next][1];
                eggs[next][0] += eggs[nowIdx][1];
            }
        }
    }
}