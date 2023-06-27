package 백준.boj_230627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리 {
    static int[] binaryTree = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;

            binaryTree[idx++] = Integer.parseInt(input);
        }

        postOrder(0, idx - 1);
    }

    public static void postOrder(int idx, int end) {
        if (idx > end) return;

        int mid = idx + 1;
        while (mid <= end && binaryTree[mid] < binaryTree[idx]) {
            mid++;
        }

        postOrder(idx + 1, mid - 1);    // left
        postOrder(mid, end);    // right

        System.out.println(binaryTree[idx]);
    }
}
