package PRGRMS.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];    // 방문처리

        for (int r = 0; r < n; r++) {

            // bfs
            if (!visited[r]) {
                Queue<Integer> q = new LinkedList<>();  // r 정보만 담을 거임

                q.add(r);  // 첫 값
                visited[r] = true;   // 방문처리

                while (!q.isEmpty()) {
                    int tmpR = q.poll();

                    // 열 검사
                    for (int i = 0; i < n; i++) {
                        if (computers[tmpR][i] == 1 && !visited[i]) {
                            q.add(i);
                            visited[i] = true;
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}