import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 입력받을 문자열 개수

		for (int i = 0; i < N; i++) {
			System.out.println(solve(br.readLine()));
		}

	}

	/*
	 * solve 메소드 생성
	 * stack 사용하여 '('입력시 스택에 추가 (push)
	 * ')' 입력시 스택에서 제거(pop) - ')'이 먼저 들어오게 되면 아무것도 추가되지 않으므로 "NO" return
	 * 짝이 맞을 경우 스택이 비어있으면 "YES" return 
	 * 비어있지 않으면 "NO" return 
	 */
	public static String solve(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (stack.empty()) {
				return "NO";
			} else {
				stack.pop();
			}
		}

		if (stack.empty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
