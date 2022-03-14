import java.util.Scanner;

public class N10818 {

	/**
	 * 9개의 정수가 주어질 때 배열을 이용하여 최댓값 구하기 (10818 -> 2562)
	 */

	public static void main(String[] args) {

		/**
		 * 'Scanner'를 이용하여 길이가 9인 배열을 입력받아 초기화한다
		 *  최댓값을 입력받을 변수 'max'와 배열의 순서를 나타내줄 변수 'count', 'index'를 초기화한다
		 */

		Scanner sc = new Scanner(System.in);
		int[] arr = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),
				sc.nextInt(), sc.nextInt(), };
		sc.close();

		int max = 0;
		int count = 0;		
		int index = 0;
		
		/**
		 * 'value'값이 'arr'배열값일 동안 반복한다
		 * 'value'값이 'max'보다 크다면 'max=value', 'index=count'로 저장하고 
		 * 첫째줄에 'max'값 출력, 둘째줄에 'index'값을 출력한다
		 */

		for (int value : arr) {
			count++;

			if (value > max) {
				max = value;
				index = count;
			}
		}
		System.out.print(max + "\n" + index);
	}
}