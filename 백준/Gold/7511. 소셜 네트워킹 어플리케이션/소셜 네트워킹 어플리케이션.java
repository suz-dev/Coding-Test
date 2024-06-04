import java.util.*;
import java.io.*;

// union-find
public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            sb.append("Scenario "+t+":\n");

            int n = Integer.parseInt(br.readLine());    // 유저수
            int k = Integer.parseInt(br.readLine());    // 관계 수

            parents = new int[n];
            for(int i = 0; i < n; i++) parents[i] = i;

            while(k-- > 0){
                st = new StringTokenizer(br.readLine());

                // 7942
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            // 관계 구하기
            int m = Integer.parseInt(br.readLine());
            while(m-- > 0){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(find(u) == find(v)) sb.append(1+"\n");
                else sb.append(0+"\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa <= pb) parents[pb] = pa;
        else parents[pa] = pb;
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}