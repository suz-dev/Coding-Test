import java.util.Scanner;

public class N10818 {

	/**
	 * 9���� ������ �־��� �� �迭�� �̿��Ͽ� �ִ� ���ϱ� (10818 -> 2562)
	 */

	public static void main(String[] args) {

		/**
		 * 'Scanner'�� �̿��Ͽ� ���̰� 9�� �迭�� �Է¹޾� �ʱ�ȭ�Ѵ�
		 *  �ִ��� �Է¹��� ���� 'max'�� �迭�� ������ ��Ÿ���� ���� 'count', 'index'�� �ʱ�ȭ�Ѵ�
		 */

		Scanner sc = new Scanner(System.in);
		int[] arr = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),
				sc.nextInt(), sc.nextInt(), };
		sc.close();

		int max = 0;
		int count = 0;		
		int index = 0;
		
		/**
		 * 'value'���� 'arr'�迭���� ���� �ݺ��Ѵ�
		 * 'value'���� 'max'���� ũ�ٸ� 'max=value', 'index=count'�� �����ϰ� 
		 * ù°�ٿ� 'max'�� ���, ��°�ٿ� 'index'���� ����Ѵ�
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