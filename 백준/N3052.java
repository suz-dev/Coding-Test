import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3052 {

	/**
	 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한 다음, 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 나머지의 값으로 나올 수 있는 0 ~ 41 까지를 담을 수 있는 'boolean'배열 'arr'를 생성한다('boolean'배열의 'default'값은 'false'이다) 
		 * 'BufferedReader'를 통해 숫자를 입력받는다
		 * 반복문을 실행하여 입력받은 값에 %42를 실행한 값의 'index'를 'true'로 바꿔준다 
		 * 반복문 종료 후 개수를 저장할 변수 'count'를 선언한 후 다음 반복문을 실행하여 첫번째 반복문에서 'true'로 바꿔준 값에 대하여 'count++'를 실행한다 
		 * 반복문 종료 후 'count'값을 출력한다
		 */

		boolean[] arr = new boolean[42];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true;
		}

		int count = 0;

		for (boolean value : arr) {
			if (value) {
				count++;
			}
		}
		System.out.println(count);
	}

}
