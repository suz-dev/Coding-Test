import java.util.Scanner;

public class N8958 {

	/*
	 * ����: ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ���  �־�����. 
	 * ���ڿ��� 'O'�� 'X'������ �̷���� �ִ�. 'O'�� ������ ���� ���̰�, 'X'�� ������ Ʋ�� ���̴�. ������ ���� ��� �� ������ ������ �� �������� ���ӵ� 'O'�� ������ �ȴ�.
	 * 
	 * 'Scanner'�� ���� ���ڿ��� ���̸� �Է¹޴´� (�׽�Ʈ ���̽��� ����) 
	 * 'for'���� ���� �Է¹��� ���ڿ��� ���̸�ŭ ���ڸ� �Է¹޴´� ('O' or 'X') 
	 * 'Scanner'�� �����Ѵ�
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		sc.close();

		/*
		 * �ݺ����� ���� ������ ������ �հ踦 ���Ѵ� 'cnt' ������ ���� 'O'�� ���ӵ� Ƚ���� �Է� �ް� 'sum'������ ���� 'cnt'�� ���� �հ踦 �Է¹޴´� 
		 * ����'for'���� 'arr[i]'�� ���̸�ŭ �ݺ��ϴ� ���� 'charAt()'�޼ҵ带 ���� 'arr[i]'�� ��Ҹ� �˻��Ͽ� 'O'�� ��� 'cnt'�� 1 ������Ű�� �׷��� ���� ���(X) 'cnt'�� 0���� �ʱ�ȭ�Ѵ� 
		 * 'sum'�� 'cnt'���� �����Ͽ� ���Ѵ� 
		 * ������ ���ڿ� �˻縦 ��ģ �� 'sum'�� ���� ����Ѵ�
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
