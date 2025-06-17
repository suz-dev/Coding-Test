

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(Integer i : arr){
            sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}