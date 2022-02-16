import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 연산자 개수
		String input = br.readLine(); // 연산식 입력받기

		Map<Character, Integer> map = new HashMap<>();

		char key = 'A'; // 피연산자는 A~Z
		for (int i = 0; i < N; i++) { // 피연산자의 개수에 해당하는 수 입력받아 map에 put
			map.put(key, Integer.parseInt(br.readLine()));
			key++;
		}

		Stack<Double> stack = new Stack<Double>();

		// input 문자열에 대해 char[]로 바꾼 만큼 반복
		for (char c : input.toCharArray()) {
			if (Character.isAlphabetic(c)) { // c번째 문자에 대해 영문자 확인 - true 일 때
				stack.push(Double.valueOf(map.get(c))); // c번째 char에 대한 value값을 double형으로 stack에 저장
			} else { // 영문자가 아닐 경우
				double tmp = calculate(stack.pop(), stack.pop(), c); // stack의 요소 두개를 뽑아 calculate메소드 실행
				stack.push(tmp); // 연산 결과를 stack에 push
			}
		}

		System.out.printf("%.2f", stack.pop());

	}

	// 연산을 수행할 메서드
	private static double calculate(double num1, double num2, char ch) {

		switch (ch) {
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
