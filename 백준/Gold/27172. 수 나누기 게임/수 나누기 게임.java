import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] selected;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[1000001];
        answer = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            selected[arr[i]] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            int start = arr[i];
            for (int j = start * 2; j < 1000001; j += start) {

                if (selected[j] > 0) {
                    answer[selected[j]]--;
                    answer[selected[start]]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}