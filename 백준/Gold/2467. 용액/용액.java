import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int now = arr[i];

            if(now < 0) list.add(new int[]{-1, now * (-1)});
            else list.add(new int[]{1, now});
        }

        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for(int i = 0; i < N - 1; i++){
            int[] a = list.get(i);
            int[] b = list.get(i + 1);

            int cal = Math.abs((a[0] * a[1]) + (b[0] * b[1]));

            if(cal < min) {
                answer[0] = a[0] * a[1];
                answer[1] = b[0] * b[1];
                min = cal;
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
}