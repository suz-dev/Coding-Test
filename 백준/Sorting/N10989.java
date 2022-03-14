import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] cnt = new int[10001]; // 카운팅 배열 (수의 범위 0~10000)

		int N = Integer.parseInt(br.readLine()); // 입력받을 숫자의 개수

		for (int i = 0; i < N; i++) {
			// 입력받은 숫자에 대한 cnt 배열의 인덱스 값 + 1
			cnt[Integer.parseInt(br.readLine())]++;
		}

		// 0은 입력범위에 없으므로 1부터 시작
		for (int i = 1; i < cnt.length; i++) {
			// i 값의 개수가 0이 될 때 까지 출력
			while (cnt[i] > 0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		System.out.println(sb);

	}

}
