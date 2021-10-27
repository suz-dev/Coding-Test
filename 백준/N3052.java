import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N3052 {

	/**
	 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한 다음, 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 'HashSet'을 사용하여 배열 없이 프로그래밍 하기 ('Set'의 파생클래스로 순서개념이 없고 중복을 허용하지 않음)
		 * 'BufferedReader'를 통해 숫자를 입력받는다
		 * 'HashSet<Integer>'로 정수타입의 변수 'h'를 선언한다
		 * 반복문을 실행하여 'HashSet.add()'메소드를 통해 입력받은 정수를 42로 나눈 나머지값을 'HashSet'에 저장한다
		 * 중복값이 없을 경우 'True', 중복값이 없을 경우 저장하지 않고 'False'를 반환한다
		 * 
		 * 반복문을 빠져나와 'HashSet'의 크기를 반환하는 'HashSet.size()'를 통해 출력한다
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> h = new HashSet<Integer>();

		for (int i = 0; i < 10; i++) {
			h.add(Integer.parseInt(br.readLine()) % 42);
		}

		System.out.println(h.size());
	}

}
