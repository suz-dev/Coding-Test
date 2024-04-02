import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int divA = A % p;
            int divB = B % p;
            int divC = C % p;

            if(divA == 0 && divB == 0 || divA == 0 && divC == 0 || divB == 0 && divC == 0) System.out.println(1);
            else System.out.println(0);

        }
    }

}