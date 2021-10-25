import java.util.Scanner;

public class N3052 {
	
	/**
	 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한 다음, 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'를 사용하여 수를 입력받아야 한다
		 * 길이가 10인 'arr'배열을 선언한다
		 * 나머지에 대한 중복값의 개수를 저장할 변수 'k'를 선언한다
		 * 중복값이 없는 경우를 저장할 변수 'count'를 선언한다
		 */

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		int k = 0;
		int count = 0;
		
		/**
		 * 반복문을 통해 10개의 숫자를 입력받아 42로 나눈 값을 'arr'배열에 저장한다
		 * 
		 * 다음 반복문을 통해 중복값이 존재하는지에 대한 검사를 실행한다
		 * 이중'for'문을 통해 배열 'arr[i]'와 'arr[j]'를 순차적으로 비교하여 중복값을 찾는다
		 * 중복값이 존재할 경우 'k++'를 실행한다
		 * 
		 * 반복문을 빠져나온 뒤 조건문을 통해 중복값이 없는 경우('k == 0'인 경우) 'count++'를 실행한다
		 */

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt() % 42;
		}

		for (int i = 0; i < arr.length; i++) {
			k = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					k++;
				}
			}

			if (k == 0) {
				count++;
			}
		}
		sc.close();
		System.out.println(count);
	}

}
