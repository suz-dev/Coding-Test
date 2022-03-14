import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1546 {

	/**
	 * 배열 없이 프로그래밍 하기
	 * 'BufferedReader'를 통해 입력 개수 'N'을 입력받는다
	 * 'StringTokenizer'를 통해 'BufferedReader.readLine()'으로 입력받는 값을 공백으로 구분한다
	 * 
	 * 최대값을 저장할 변수 'max'를 선언하고 -1로 초기화시켜준다
	 * 점수의 합을 저장할 'double'형 변수 'sum'을 선언한 후 0으로 초기화시켜준다
	 * 
	 * 반복문을 통해 'N'번 동안 점수를 입력받는다
	 * 'if'문을 통해 입력받은 값이 'max'보다 클 경우 'value'를 'max'로 저장한다
	 * 반복문이 실행될 동안 'value'값을 'sum'에 더해준다 (평균을 하나씩 구하지 않고, 점수를 먼저 더한 후 한번에 연산한다)
	 * 
	 * 새로운 평균값을 출력한다
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int max = -1;
		double sum = 0;

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());

			if (value > max) {
				max = value;
			}
			sum += value;
		}
		System.out.println(((sum / max) * 100 / N));
	}
}
