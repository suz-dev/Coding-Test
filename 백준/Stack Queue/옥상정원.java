package 백준.boj_230603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            // 앞 빌딩이 현재 빌딩보다 낮다면 제외
            while (!stack.isEmpty() && stack.peek() <= tmp) {
                stack.pop();
            }

            stack.push(tmp);
            result += (stack.size() - 1);   // 감시자 제외 개수 count
        }

        System.out.println(result);
    }
}