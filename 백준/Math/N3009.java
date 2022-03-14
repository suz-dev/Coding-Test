
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//네 번째 점
public class N3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백으로 분리 (스페이스)

		// 각 좌표별 배열 생성
		int[] A = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		st = new StringTokenizer(br.readLine(), " "); // 공백 분리 (엔터)
		int[] B = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		st = new StringTokenizer(br.readLine(), " "); // 공백 분리 (엔터)
		int[] C = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

		int x;
		int y;

		if (A[0] == B[0]) {
			x = C[0];
		} else if (A[0] == C[0]) {
			x = B[0];
		} else {
			x = A[0];
		}

		if (A[1] == B[1]) {
			y = C[1];
		} else if (A[1] == C[1]) {
			y = B[1];
		} else {
			y = A[1];
		}

		System.out.println(x + " " + y);

	}
}