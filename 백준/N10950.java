import java.util.Scanner;

public class N10950 {

	public static void main(String[] args) {
	
	/** 덧셈을 반복할 횟수 입력받기
	 * 'Scanner' 실행
	 * 'int T': 반복 횟수 입력값 변수
	 * 'int[] answer': 수식 결과값 저장 변수
	 */

		System.out.println("반복횟수를 입력하시오.");
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] answer = new int[T];

	
	/** 위에서 입력한 횟수 만큼 덧셈을 할 수 입력하기(반복문)
	 * 정수'a, b' 입력받기
	 * 'answer'에 결과값 차례대로 저장
	 * 'Scanner' 종료
	 */

		System.out.println("정수 a와 b를 입력하시오. 예) 1 2");
		for (int i = 0; i < answer.length; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			answer[i] = a + b;
		}
		scanner.close();

	/** 덧셈 실행 후 결과 별도로 출력(반복문)
	 * 배열 'answer'의 요소 수만큼 반복수행
	 * 'int k': 'answer'의 각 요소가 할당될 변수를 선언
	 */
		
		System.out.println("답: ");
		for (int k : answer) {
			System.out.println(k);
		}
	}

}
