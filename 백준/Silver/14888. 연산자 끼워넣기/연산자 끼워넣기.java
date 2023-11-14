import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, R;
    static int[] nums, operators;
    static boolean[] isSelected;
    static int[] arr;

    static int minVal = 1000000001;
    static int maxVal = -1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        R = N - 1;

        nums = new int[N];
        operators = new int[R];
        isSelected = new boolean[R];
        arr = new int[R];

        // 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0) continue;

            for(int j = 0; j < tmp; j++){
                operators[idx++] = i;
            }
        }

        permutation(0);

        bw.write(maxVal + "\n" + minVal);

        bw.flush();
        bw.close();
        br.close();
    }

    // 연산자 순열 만들기
    public static void permutation(int cnt){
        if(cnt == R) {
            calculation();
            return;
        }

        for(int i = 0; i < R; i++){
            if(isSelected[i]) continue;

            arr[cnt] = operators[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    // 계산
    public static void calculation(){
        int val = nums[0];

        for(int i = 0; i < R; i++){
            int op = arr[i];
            int nextNum = nums[i+1];

            if(op == 0) val += nextNum;
            else if(op == 1) val -= nextNum;
            else if(op == 2) val *= nextNum;
            else if(op == 3) {
                if(val < 0){
                    val *= (-1);
                    val /= nextNum;
                    val *= (-1);
                }else if (val > 0){
                    val /= nextNum;
                }
            }
        }

        if(val < minVal) minVal = val;
        if(val > maxVal) maxVal = val;
    }
}