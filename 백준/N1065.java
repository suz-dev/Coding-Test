import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수 문제

public class N1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(arithmetic_sequence(Integer.parseInt(br.readLine())));

	}

	public static int arithmetic_sequence(int num) {

		int cnt = 0;

		if (num < 100) { // 두자리 수는 모두 한수

			return num;

		} else {

			cnt = 99;

			if (num == 1000) { // 예외처리
				num = 999;
			}

			for (int i = 100; i <= num; i++) {

				if ((i / 100) - ((i % 100) / 10) == ((i % 100) / 10) - (i % 10)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
