import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 미터
		int B = Integer.parseInt(st.nextToken()); // 밤에 떨어지는 미터
		int V = Integer.parseInt(st.nextToken()); // 나무의 높이

		int day = (V - B) / (A - B);

		if ((V - B) % (A - B) != 0) {
			day++;
		}

		System.out.println(day);
	}

}
