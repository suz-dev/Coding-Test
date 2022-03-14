import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2741 {
	
	/**
	 * 'for'문 빠른 'A+B' 추가버전
	 * 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. 
	 * x는 테스트 케이스 번호이고 1부터 시작하며, 'C = A+B'이다.
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/** 
		 * 정수형 변수 'a', 'b' 추가
		 */
		int T = Integer.parseInt(br.readLine());
		int a;
		int b;

		StringTokenizer st = null;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			bw.write("Case #" + (i + 1) + ": " + a + " + " + b + " = " + (a + b));
			bw.newLine();
		}

		br.close();

		bw.flush();
		bw.close();

	}

}
