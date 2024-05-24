import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] galaxy, bridge;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 은하의 수
        M = Integer.parseInt(st.nextToken());   // 철도 개수

        galaxy = new int[N + 1];
        bridge = new int[N + 1];
        for(int i = 1; i <= N; i++){
            galaxy[i] = Integer.parseInt(br.readLine());    // 각 은하계 행성 수
            bridge[i] = i;  // 초기화
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                union(a, b);
            }

            System.out.println(galaxy[find(a)]);
        }
    }

    // union find
    private static void union(int a, int b){
        int na = find(a);
        int nb = find(b);

        if(na < nb) bridge[nb] = na;
        else bridge[na] = nb;

        int sum = galaxy[na] + galaxy[nb];
        galaxy[na] = sum;
        galaxy[nb] = sum;
    }

    private static int find(int x){
        if(bridge[x] == x) return x;
        return bridge[x] = find(bridge[x]);
    }
}