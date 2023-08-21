import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int[] arr = new int[N];
        arr[0]++;

        int idx = 0;
        while (true) {
            if (arr[idx] == M) break;

            if (arr[idx] % 2 != 0) {
                arr[(idx + L) % N]++;
                idx = (idx + L) % N;
            } else {
                int tmp = idx - L >= 0 ? idx - L : N + (idx - L);
                arr[tmp]++;
                idx = tmp;
            }

            cnt++;

        }
        System.out.println(cnt);
    }
}