import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    static int N, res = Integer.MAX_VALUE;
    static int[] population;
    static ArrayList<Integer>[] adj;
    static boolean isAreaA[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        adj = new ArrayList[N + 1];

        // 인구 정보 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>(); // 인접리스트 초기화
        }

        // 인접한 구역 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 구역 나누기
        isAreaA = new boolean[N + 1];
        selectA(1);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }

    // 부분집합
    private static void selectA(int idx) {
        // A선거구에 해당하는 구역을 모두 선택했다면
        if (idx == N + 1) {
            // 각 선거구에 포함된 구역이 모두 연결되었는지 확인
            if (check()) {
                // 연결되었다면
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (isAreaA[i]) sumA += population[i];
                    else sumB += population[i];
                }
                res = Math.min(res, Math.abs(sumA - sumB)); // 최솟값 갱신
            }
            return;
        }

        // 이 구역을 A선거구로 선택
        isAreaA[idx] = true;
        selectA(idx + 1);

        // 이 구역을 A선거구로 미선택
        isAreaA[idx] = false;
        selectA(idx + 1);
    }

    // 구역간 연결 check
    private static boolean check() {
        boolean[] visited = new boolean[N + 1];

        // A선거구 구역에 포함된 한 구역을 찾기
        int areaA = -1;
        for (int i = 1; i <= N; i++) {
            if (isAreaA[i]) {
                areaA = i;
                break;
            }
        }

        // B선거구 구역에 포함된 한 구역을 찾기
        int areaB = -1;
        for (int i = 1; i <= N; i++) {
            if (!isAreaA[i]) {
                areaB = i;
                break;
            }
        }

        // 선거구에 포함된 구역이 없다면 false
        // 각 구역은 두 선거구 중 하나에 포함
        if (areaA == -1 || areaB == -1) return false;

        // 먼저 A 선거구에 포함된 구역들이 모두 연결되었는지 확인
        Queue<Integer> q = new LinkedList<>();
        q.add(areaA);
        visited[areaA] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 구역과 연결된 구역들을 확인
            for (int i = 0; i < adj[now].size(); i++) {
                // 이미 확인한 곳이면 pass || A 구역이 아니면 pass
                if (visited[adj[now].get(i)] || !isAreaA[adj[now].get(i)]) continue;

                q.add(adj[now].get(i));
                visited[adj[now].get(i)] = true;
            }
        }

        // B 선거구에 포함된 구역들이 모두 연결되었는지 확인
        q.add(areaB);
        visited[areaB] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 구역과 연결된 구역들을 확인
            for (int i = 0; i < adj[now].size(); i++) {
                // 이미 확인한 곳이면 pass || B 구역이 아니면 pass
                if (visited[adj[now].get(i)] || isAreaA[adj[now].get(i)]) continue;

                q.add(adj[now].get(i));
                visited[adj[now].get(i)] = true;
            }
        }

        // 한 곳이라도 연결되지 않았다면 false
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }
}