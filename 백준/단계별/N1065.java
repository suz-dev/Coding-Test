import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수(각 자리수가 수열을 이루는 수) 문제

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

				int hun = i / 100; // 백의 자릿수
				int ten = (i / 10) % 10; // 십의 자릿수
				int one = i % 10; // 일의 자릿수

				if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이룸
					cnt++;
				}
			}
		}

		return cnt;

	}
}
