package 백준.boj_230710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs

public class 뱀과사다리게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사다리의 수
        int M = Integer.parseInt(st.nextToken());   // 뱀의 수

        int[] path = new int[101];
        boolean[] visited = new boolean[101];
        visited[0] = visited[1] = true;
        for (int i = 0; i < 101; i++) {
            path[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            path[x] = y;
        }

        int cnt = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);

        while (!q.isEmpty()) {
            cnt++;

            int size = q.size();
            for (int s = 0; s < size; s++) {

                int r = q.poll();
                for (int d = 1; d <= 6; d++) {
                    int nr = r + d;

                    if (nr == 100) {
                        System.out.println(cnt);
                        return;
                    }

                    if (nr > 100 || visited[nr]) continue;

                    if (path[nr] == 0) {
                        visited[nr] = true;
                        q.add(nr);

                    } else if (path[nr] != 0 && !visited[path[nr]]) {
                        visited[path[nr]] = true;
                        q.add(path[nr]);
                    }
                }
            }
        }
    }
}


