package 백준.boj_230711;

import java.io.*;
import java.util.*;

// BFS
public class DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // TC

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000]; // 정답 명령어를 담는 배열

            q.add(A);
            visited[A] = true; // 방문 처리
            command[A] = "";    // 값이 null로 들어가기 때문에 첫 값 공백처리 필요

            while (!q.isEmpty() && !visited[B]) {
                int n = q.poll();

                // 각 계산식
                int D = (n * 2) % 10000;
                int S = n == 0 ? 9999 : n - 1;
                int L = (n % 1000) * 10 + n / 1000;
                int R = (n % 10) * 1000 + n / 10;

                // 모든 명령 시도
                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;  // 방문처리
                    command[D] = command[n] + "D"; // 명령어 추가
                }

                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[n] + "S";
                }

                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[n] + "L";
                }

                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[n] + "R";
                }
            }
            System.out.println(command[B]); // 최소 명령
        }
    }
}