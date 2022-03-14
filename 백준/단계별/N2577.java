import java.util.Scanner;

public class N2577 {
	
	/**
	 * 100���� ũ��, 1000���� ���� �ڿ��� ������ �Է¹޾� �� ���� ����ϰ�, 
	 * ����� ������� 0 ~ 9�� ������ ���ڰ� �� ���� �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'�� ���� ������ ������ ������ ������ �Է¹޴´�
		 * ����� ����� 'value'������ ���������� ������ �� 
		 * 'Integer.toString()'�޼ҵ带 ����Ͽ� 'String' ���� 'str'�� �����Ѵ�
		 */
		
		Scanner sc = new Scanner(System.in);
		int value = (sc.nextInt() * sc.nextInt() * sc.nextInt());
		String str = Integer.toString(value);
		sc.close();

		/**
		 * ù��° 'for'���� ���� 0 ~ 9������ ���� �ݺ��Ͽ� �˻��Ѵ�
		 * 'str'�� ����� ���ڸ� �����'count'������ 0���� �ʱ�ȭ�Ѵ�
		 * ���� 'for'����'str'�� ���̸�ŭ �ݺ��ϸ�
		 * 'str.charAt()'�� ���� �ش� �ε��� ���ڿ� 'i'�� ���� �� 'count++'�� �����Ѵ�
		 * (**'charAt()'�� ����� ����  -'0' / -48 �� �����ؾ��Ѵ� �׷��� ���� ��� �ƽ�Ű�ڵ忡 �����ϴ� ���ڰ� ����)
		 * ����'for'���� �������� 'count'�� ����Ѵ�
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
