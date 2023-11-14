import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums, operators;
    static int minVal = Integer.MAX_VALUE;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        operators = new int[4];

        // 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        bw.write(maxVal + "\n" + minVal);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int val, int cnt){
        if(cnt == N) {
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){
                operators[i]--; // isSelected

                if(i == 0) dfs(val + nums[cnt], cnt+1);
                else if(i == 1) dfs(val - nums[cnt], cnt+1);
                else if(i == 2) dfs(val * nums[cnt], cnt+1);
                else dfs(val / nums[cnt], cnt+1);

                operators[i]++;
            }
        }
    }
}