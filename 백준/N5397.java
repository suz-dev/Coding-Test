import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 입력
 * BufferedReader 사용
 * 테스트 케이스 개수 입력 - N
 * 
 * 동작
 * solve 메소드 구현 (입력받은 String에 대하여 char[]로 변환)

 * Stack 사용 - left, right
 * cursor를 따로 두지 않고 char[i]의 위치가 커서로 stack left, right로 요소가 나뉘어 들어가도록 함
 * 
 * char[]의 각각의 요소에 대해 swith-case문 실행
 * '-' : left 스택의 제일 끝 요소 삭제
 * '<' : left 스택의 제일 끝 요소를 right으로 이동
 * '>' : right 스택의 제일 끝 요소를 left로 이동
 * 
 * StringBuilder를 통해 Stack left, right의 요소를 하나의 문자열로 리턴
 * 
 * 출력
 * main메소드에서 입력받은 문자열만큼 반복문을 통해 solve메소드 실행 후 출력
 */
public class N5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int i = 0; i < N; i++) {
			System.out.println(solve(br.readLine()));
		}

	}

	private static String solve(String input) {

		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		char[] ch = input.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '<':
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
				break;

			case '>':
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
				break;

			case '-':
				if (!left.isEmpty()) {
					left.pop();
				}
				break;

			default:
				if (ch[i] != '<' && ch[i] != '>' && ch[i] != '-') {
					left.push(ch[i]);
				}
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (char c : left) {
			sb.append(c);
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		return sb.toString();

	}

}
