import java.util.Scanner;

public class N11720 {

	/*
	 * 숫자의 개수 'N'을 입력받는다
	 * 공백없는 'N'개의 숫자를 'String'으로 입력받는다
	 * 
	 * 각각의 숫자를 더할 변수 'sum'을 선언한다
	 * 
	 * 'for'문을 통해 문자열로 입력받은 각각의 원소를 'charAt(0)' ~ 'charAt(N)'까지 누적 합계를 구한다
	 * 'charAt()'은 해당 문자의 아스키 코드를 반환하므로 '-48' 또는 '0'을 사용하여 출력해야 한다 (숫자출력)
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String s = sc.next();
		sc.close();

		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += s.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}

}
