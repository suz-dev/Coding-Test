import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 900528;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String key = br.readLine();

        int[] arr = new int[200];
        int result = 0;
        int size = s.length();

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - '!';
            arr[idx] = i + 1;
        }

        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - '!';
            result = (result * size + arr[idx]) % MOD;
        }

        System.out.println(result);
    }
}