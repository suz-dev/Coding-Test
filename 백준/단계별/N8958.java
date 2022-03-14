import java.util.Scanner;

public class N8958 {

	/*
	 * 문제: 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이  주어진다. 
	 * 문자열은 'O'와 'X'만으로 이루어져 있다. 'O'는 문제를 맞은 것이고, 'X'는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 'O'의 개수가 된다.
	 * 
	 * 'Scanner'를 통해 문자열의 길이를 입력받는다 (테스트 케이스의 개수) 
	 * 'for'문을 통해 입력받은 문자열의 길이만큼 문자를 입력받는다 ('O' or 'X') 
	 * 'Scanner'를 종료한다
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		sc.close();

		/*
		 * 반복문을 통해 점수와 점수의 합계를 구한다 'cnt' 변수를 통해 'O'이 연속된 횟수를 입력 받고 'sum'변수를 통해 'cnt'의 누적 합계를 입력받는다 
		 * 이중'for'문을 'arr[i]'의 길이만큼 반복하는 동안 'charAt()'메소드를 통해 'arr[i]'의 요소를 검사하여 'O'일 경우 'cnt'를 1 증가시키고 그렇지 않을 경우(X) 'cnt'를 0으로 초기화한다 
		 * 'sum'에 'cnt'값을 누적하여 더한다 
		 * 원소의 문자열 검사를 마친 뒤 'sum'의 값을 출력한다
		 */

		for (int i = 0; i < arr.length; i++) {

			int cnt = 0;
			int sum = 0;

			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			System.out.println(sum);
		}

	}

}
