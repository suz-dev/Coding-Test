import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 후위 표기식2
 * 
 * 입력 - BufferedReader 사용
 * 1. 피연산자의 개수 int N
 * 2. 후위 표기식 String (피연산자 + 연산자)
 * 3. 피연산자에 대응하는 값 int
 * 
 * 동작
 * 1. 연산을 수행하는 메서드 별도 구현
 * 2. 피연산자에 대응하는 값을 저장할 HashMap 생성
 * 피연산자에 대해 입력받는 숫자와 key-value로 Map에 저장
 * 
 * 3. 연산을 저장할 Stack 생성
 * String.length만큼 반복문 실행
 * - 피연산자일 경우 Stack에 map의 value값 push
 * - 연산자일 경우 Stack에 저장한 값 두 개를 pop하여 연산 메서드 실행
 * 
 * 출력
 * 연산 결과를 소수점 둘째 자리까지 출력
 */
public class N1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 피연산자 개수
		String cal = br.readLine(); // 연산식

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char key = 'A';
		for (int i = 0; i < N; i++) {
			map.put(key, Integer.parseInt(br.readLine()));
			key++;
		}

		Stack<Double> stack = new Stack<>();
		for (char c : cal.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				stack.push(Double.valueOf(map.get(c)));
			} else {
				stack.push(calculate(stack.pop(), stack.pop(), c));
			}
		}

		System.out.printf("%.2f", stack.pop());

	}

	// 연산 메서드 구현
	private static double calculate(double num1, double num2, char c) {

		switch (c) {
		case '+':
			return num2 + num1;
		case '-':
			return num2 - num1;
		case '*':
			return num2 * num1;
		case '/':
			return num2 / num1;
		default:
			return -1;
		}
	}

}
