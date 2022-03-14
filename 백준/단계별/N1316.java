import java.util.Scanner;

public class N1316 {

	// 참고 : https://st-lab.tistory.com/69 - boolean 함수 이용
	static Scanner sc = new Scanner(System.in);

	/*
	 * check()를 통해 true 값을 반환할 단어의 개수를 저장할 변수 count 
	 * 입력받을 단어의 개수 N
	 * 
	 * N만큼의 반복문 실행 check()의 리턴값이 true 일 때, 
	 * count++ 실행
	 * 
	 * count값 출력
	 */

	public static void main(String[] args) {

		int count = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	 * 단어를 체크할 boolean 타입 함수 check()
	 * 
	 * boolean 배열 선언 ('a'-'z' 담을 배열) 
	 * 연속된 문자를 판별할 변수 prev 선언 
	 * next()를 통해 문자열 입력받음
	 * 
	 * 문자열의 길이만큼 반복문 실행 
	 * 문자열의 각 문자를 저장할 정수형 변수 now 선언 (현재 문자)
	 */
	public static boolean check() {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);

			/*
			 * 앞선 문자 =/= 현재 문자(i번째 문자)
			 * 
			 * - 해당 문자가 처음 나오는 경우 (false) 
			 * 해당 배열에 대해 true 값으로 바꿔준다 
			 * prev값을 now 값으로 대체
			 * 
			 * - 해당 문자가 이미 나온 적이 있는 경우 (check[now - 'a'] == true 일 때) 
			 * false 리턴 (함수 종료)
			 * 
			 * 앞선 문자 = 현재 문자(i) - 연속된 문자일 때 
			 * continue;
			 * 
			 * true 값 리턴
			 */
			if (prev != now) {

				if (check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				}

				else {
					return false;
				}
			}

			else {
				continue;
			}
		}
		return true;
	}
}