import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int[] num;
    static boolean[] isSelected;
    static int N, R;

    public static void solution(int n, int m){
        N = n;
        R = m;

        arr = new int[N + 1];
        for(int i = 1; i <= N; i++) arr[i] = i;

        num = new int[R];
        isSelected = new boolean[N + 1];

        permutation(1, 0);
    }

    public static void permutation(int start, int cnt){
        if(cnt == R){
            for(int i = 0; i < R; i++) System.out.print(num[i] + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            num[cnt] = i;
            permutation(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);
    }
}