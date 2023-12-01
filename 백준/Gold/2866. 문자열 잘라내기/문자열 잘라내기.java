import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R, C, cnt = 0;
    static char[][] map, tmp;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cnt = 0;

        tmp = new char[R][C];
        map = new char[C][R-1];
        for (int i = 0; i < R; i++) {
            tmp[i] = br.readLine().toCharArray();
        }

        //문자열 90도 회전
        for(int i=0; i<C; i++) {
            for(int j=1; j<R; j++) {
                map[i][j-1] = tmp[j][i];
            }
        }

        boolean flag = false;
        R--;
        for(int i=0; i<R; i++) {
            Set<String> set = new HashSet<>();
            for(int j=0; j<C; j++) {
                String str = String.valueOf(map[j], i, R-i);
                set.add(str);
            }
            if(set.size() == C) cnt++;
            else {
                System.out.println(cnt);
                flag = true;
                break;
            }
        }

        if (!flag) System.out.println(cnt);
    }
}