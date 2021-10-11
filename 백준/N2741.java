import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 자연수 'N'이 주어졌을 때, 1부터 'N'까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오. 
 * 'BufferedReader' 사용
 */
public class N2741 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(i);
		}
		
	}

}
