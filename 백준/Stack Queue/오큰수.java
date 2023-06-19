package 백준.boj_230619;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();
        
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {    // 이전 값과 비교
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);  // index
        }

        // 빈 곳에 대해 -1 처리
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int val : arr) {
            bw.write(val + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
