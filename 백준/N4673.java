
public class N4673 {

	public static void main(String[] args) {

		// 1 ~ 10000 에 대한 boolean 배열 선언 (return된 수에 대해 boolean 배열을 통해 true로 바꿔줌)
		boolean[] check = new boolean[10001];

		// 1부터 10000까지 반복문 실행 (양의 정수)
		for (int i = 1; i < 10001; i++) {
			int n = d(i);

			if (n < 10001) // 반복문 실행 결과 10000 초과의 수는 필요 없기 때문에 if 문으로 가려냄
				check[n] = true;
		}

		// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존의 데이터를 더하는 방식 사용 - 긴 문자열을 더할 때 유용
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (!check[i]) { // boolean 배열 check[]에서 false 인덱스만 출력
				sb.append(i).append('\n'); // append() : 문자열을 더해줌

			}
			System.out.println(sb);
		}
	}

	/*
	 * 주어진 정수 number를 int 값으로 리턴받는 함수 d() 작성 (ex.d(75) = 75+7+5 = 87 구현) 
	 * d() 함수를 실행하는 동안 값을 더할 정수 변수 sum 선언
	 * 
	 * 입력받는 정수 number에 대하여 while문 실행 number + number의 십의자리 수 + number의 1의자리 수
	 * 
	 * sum 리턴 (리턴된 수는 생성자가 있는 수, 구해야 하는 것은 생성자가 없는 self number)
	 */

	public static int d(int number) {

		int sum = number;

		while (number != 0) {
			sum += (number % 10);
			number = number / 10;
		}
		return sum;
	}
}
