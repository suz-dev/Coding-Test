import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 시험장 수
        int[] room = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());   // 총감독관이 감시 가능한 응시자
        int C = Integer.parseInt(st.nextToken());   // 부감독관이 감시 가능한 응시자

        long ans = N;
        for (int i = 0; i < N; i++) {
            room[i] -= B;

            if(room[i] > 0){
                ans += room[i] / C;

                if(room[i] % C != 0) ans++;
            }
        }

        System.out.println(ans);
    }
}