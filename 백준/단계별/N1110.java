import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1110 {

	/**
	 * 100 미만의 수를 입력받아 사이클의 길이를 구하시오
	 * 
	 * 1) 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 
	 * 2) 주어진 수의 가장 오른쪽 자리수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 
	 * 3) 주어진 수로 돌아올 때 사이클이 끝난다.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 'BufferedReader'를 통해 정수 'k'를 입력받는다 
		 * 'do~while'문에서 입력값 'k'와 비교할 정수 'copy'를 선언한다
		 * 사이클의 길이를 나타낼 변수 'count'를 선언한다
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		br.close();

		int copy = k;
		int count = 0;

		/**
		 * 십의 자릿수와 일의 자릿수를 나누어 사이클을 통해 새로운 수를 입력받는 식을 작성한다 
		 * 십의자리(k / 10) 일의자리(k % 10) 
		 * 첫번째 사이클에서 각 자릿수의 숫자를 더한 값의 일의자리를 다음 숫자의 일의자리로 설정하고, 기존 숫자의 일의자리를 십의자리로 설정하여 새로운 숫자를 만든다 
		 * 'copy == k'가 될 때까지 반복한다 반복된 사이클의 길이를 출력한다
		 */

		do {

			k = ((k % 10) * 10) + (((k / 10) + (k % 10)) % 10);
			count++;

		} while (copy != k);

		System.out.println(count);
	}

}
