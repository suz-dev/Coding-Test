import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int sLen = S.length();
        int tLen = T.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tLen; i++) map.put(T.charAt(i), i + 1);

        int[] arr = new int[tLen + 1];
        arr[0] = sLen;

        for (int i = 0; i < sLen; i++) {
            if(!map.containsKey(S.charAt(i))) continue;

            int t = map.get(S.charAt(i));
            if (arr[t - 1] == 0) continue;

            arr[t - 1]--;
            arr[t]++;
        }

        System.out.println(arr[tLen]);
    }
}