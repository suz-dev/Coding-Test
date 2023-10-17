import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) parents[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal == 0) union(a, b);
            else if (cal == 1) System.out.println(isSameParent(a, b) == true ? "YES" : "NO");
            else continue;
        }
    }

    public static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return true;
        return false;
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) parents[parentB] = parentA;
    }
}