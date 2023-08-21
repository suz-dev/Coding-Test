import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        arr[0] = Integer.parseInt(br.readLine());

        int ans = arr[0];
        int min = Math.abs(100 - arr[0]);

        for (int i = 1; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine()) + arr[i - 1];
            int tmp = Math.abs(100 - arr[i]);

            if (tmp <= min) {
                ans = arr[i];
                min = tmp;
            }
        }
        System.out.println(ans);
    }
}