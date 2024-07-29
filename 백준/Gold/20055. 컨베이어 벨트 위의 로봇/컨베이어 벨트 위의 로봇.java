import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] robots = new int[N];

        int lv = 0;
        while(true){
            lv++;

            // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int tmp = arr[2 * N - 1];
            for(int i = 2 * N - 1; i > 0; i--){
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;

            for(int i = N - 1; i > 0; i--){
                robots[i] = robots[i - 1];
            }

            robots[0] = robots[N - 1] = 0;

            // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for(int i = N - 2; i >= 0; i--){
                if(robots[i] == 0 || robots[i + 1] != 0 || arr[i + 1] < 1) continue;

                robots[i + 1] = robots[i];
                robots[i] = 0;

                arr[i + 1]--;
            }

            robots[N - 1] = 0;

            //  올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(arr[0] != 0) {
                robots[0]++;
                arr[0]--;
            }

            //  내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt = 0;
            for(int i = 0; i < 2 * N; i++) {
                if(arr[i] <= 0) cnt++;
            }

            if(cnt >= K) {
                break;
            }
        }

        System.out.println(lv);
    }
}