import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int cnt = 1;
        for(int i = 0; i< seats.length(); i++){
            char seat = seats.charAt(i);

            if(seat == 'S') cnt++;
            else{
                cnt++;
                i++;
            }
        }
        
        cnt = cnt > N ? N : cnt;
        System.out.println(cnt);
    }
}