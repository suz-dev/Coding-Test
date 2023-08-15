package Softeer;

import java.util.*;
import java.io.*;

public class GBC {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[100];
        int preIdx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int range = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = preIdx; j < (preIdx + range); j++) {
                arr[j] = speed;
            }

            preIdx += range;
        }

        int preIdx2 = 0;
        int max = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int range = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = preIdx2; j < (preIdx2 + range); j++) {
                max = Math.max(max, speed - arr[j]);
            }

            preIdx2 += range;
        }

        System.out.println(max);
    }
}