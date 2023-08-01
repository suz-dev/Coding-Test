package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_8단변속기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String state = "";
        int changeCnt = 0;
        int pre = -1;

        for (int i = 0; i < 8; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (i == 0) {
                pre = now;
                continue;
            } else if (i > 1 && now > pre && !state.equals("ascending")) {
                state = "ascending";
                changeCnt++;
            } else if (i > 1 && now < pre && !state.equals("descending")) {
                state = "descending";
                changeCnt++;
            }

            pre = now;

            if (changeCnt > 1) {
                state = "mixed";
                break;
            }
        }

        System.out.println(state);
    }
}
