import java.util.Scanner;

public class N3052 {
	
	/**
	 * �� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���� ����, ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'�� ����Ͽ� ���� �Է¹޾ƾ� �Ѵ�
		 * ���̰� 10�� 'arr'�迭�� �����Ѵ�
		 * �������� ���� �ߺ����� ������ ������ ���� 'k'�� �����Ѵ�
		 * �ߺ����� ���� ��츦 ������ ���� 'count'�� �����Ѵ�
		 */

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		int k = 0;
		int count = 0;
		
		/**
		 * �ݺ����� ���� 10���� ���ڸ� �Է¹޾� 42�� ���� ���� 'arr'�迭�� �����Ѵ�
		 * 
		 * ���� �ݺ����� ���� �ߺ����� �����ϴ����� ���� �˻縦 �����Ѵ�
		 * ����'for'���� ���� �迭 'arr[i]'�� 'arr[j]'�� ���������� ���Ͽ� �ߺ����� ã�´�
		 * �ߺ����� ������ ��� 'k++'�� �����Ѵ�
		 * 
		 * �ݺ����� �������� �� ���ǹ��� ���� �ߺ����� ���� ���('k == 0'�� ���) 'count++'�� �����Ѵ�
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
