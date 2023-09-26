import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<int[]> jewels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());   // 무게
            int V = Integer.parseInt(st.nextToken());   // 가격

            jewels.add(new int[]{M, V});
        }

        // 무게 우선 (무게가 같을 경우 가격 우선)
        Collections.sort(jewels, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        // 가방 무게 순
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        // 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        long ans = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            // 조건에 맞는 보석 모두 우선순위 큐에 넣기
            while (idx < N && jewels.get(idx)[0] <= bags[i]) {
                pq.offer(jewels.get(idx)[1]);
                idx++;
            }

            // 가격 가장 큰 보석 더하기
            if (!pq.isEmpty()) ans += pq.poll();
        }

        System.out.println(ans);
    }
}