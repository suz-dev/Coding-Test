import java.util.*;
import java.io.*;

public class Main {

    static int[] Arr;
    static boolean[] isSelected;
    static int N = 9, R = 7;
    static int[] nums;
    static StringBuilder sb;

    public static void solution(int[] arr, int hSum){
        sb = new StringBuilder();

        Arr = arr;
        isSelected = new boolean[N];
        nums = new int[R];

        combination(0, 0, 0);
    }

    public static void combination(int start, int cnt, int sum){
        if(cnt == R){
            if(sum == 100) {
                for(int i : nums) System.out.println(i);
                System.exit(0);
            }

            return;
        }

        for(int i = start; i < N; i++){
            if(sum + Arr[i] > 100) break;

            nums[cnt] = Arr[i];
            combination(i + 1, cnt + 1, sum + Arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        solution(arr, 100);
    }
}