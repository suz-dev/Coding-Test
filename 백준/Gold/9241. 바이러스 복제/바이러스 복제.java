import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// 바이러스 복제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String a = br.readLine();
        String b = br.readLine();

        int min = Math.min(a.length(), b.length());

        int startIdx = 0;
        while (startIdx < min && a.charAt(startIdx) == b.charAt(startIdx)) {
            startIdx++;
        }

        int endIdx = 0;
        while (endIdx < min && a.charAt(a.length() - 1 - endIdx) == b.charAt(b.length() - 1 - endIdx)) {
            endIdx++;
        }

        System.out.println(startIdx >= min - endIdx ? (a.length() > b.length() ? 0 : b.length() - a.length()) : b.length() - endIdx - startIdx);
    }
}