import java.util.Scanner;

public class N2577 {
	
	/**
	 * 100보다 크고, 1000보다 작은 자연수 세개를 입력받아 그 곱을 계산하고, 
	 * 계산한 결과에서 0 ~ 9의 각각의 숫자가 몇 번씩 쓰였는지 구하는 프로그램을 작성하시오
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'를 통해 곱셈을 실행할 세개의 정수를 입력받는다
		 * 계산한 결과는 'value'변수에 정수값으로 저장한 후 
		 * 'Integer.toString()'메소드를 사용하여 'String' 변수 'str'에 저장한다
		 */
		
		Scanner sc = new Scanner(System.in);
		int value = (sc.nextInt() * sc.nextInt() * sc.nextInt());
		String str = Integer.toString(value);
		sc.close();

		/**
		 * 첫번째 'for'문을 통해 0 ~ 9까지의 수를 반복하여 검사한다
		 * 'str'의 요소의 숫자를 계산할'count'변수를 0으로 초기화한다
		 * 이중 'for'문은'str'의 길이만큼 반복하며
		 * 'str.charAt()'를 통해 해당 인덱스 문자와 'i'가 같을 때 'count++'를 실행한다
		 * (**'charAt()'를 사용할 때는  -'0' / -48 을 연산해야한다 그렇지 않을 경우 아스키코드에 대응하는 문자가 나옴)
		 * 이중'for'문을 빠져나와 'count'를 출력한다
		 */
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if ((str.charAt(j) - '0') == i) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
