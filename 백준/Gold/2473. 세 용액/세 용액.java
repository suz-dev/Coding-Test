import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long min = Long.MAX_VALUE;
    static long[] arr, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        answer = new long[3];
        for(int i = 0; i < N - 2; i++){
            int start = i;
            int mid = i + 1;
            int end = N - 1;

            while(mid < end){
                long sum = arr[start] + arr[mid] + arr[end];

                if(min > Math.abs(sum)){
                    min = Math.abs(sum);

                    answer[0] = arr[start];
                    answer[1] = arr[mid];
                    answer[2] = arr[end];
                }

                if(sum == 0){
                    break;
                }else if(sum > 0){
                    end--;
                }else{
                    mid++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}