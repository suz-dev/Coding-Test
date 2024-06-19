import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int len = s.length();

        String tmpS = s;
        int cnt = 0;
        while(true){
            char[] arr = tmpS.toCharArray();
            Queue<Character> q = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < len; i++){
                if(i % 2 == 0) q.add(arr[i]);
                else stack.add(arr[i]);
            }

            tmpS = "";
            while(!q.isEmpty()) tmpS += q.poll();
            while(!stack.isEmpty()) tmpS += stack.pop();

            if(tmpS.equals(s)) break;

            cnt++;
        }
        
        tmpS = s;
        X %= (cnt + 1);
        while(X-- > 0){
            char[] arr = tmpS.toCharArray();
            Queue<Character> q = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < len; i++){
                if(i % 2 == 0) q.add(arr[i]);
                else stack.add(arr[i]);
            }

            tmpS = "";
            while(!q.isEmpty()) tmpS += q.poll();
            while(!stack.isEmpty()) tmpS += stack.pop();
        }

        System.out.println(tmpS);
    }
}