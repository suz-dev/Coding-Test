
public class N4673 {

	public static void main(String[] args) {

		// 1 ~ 10000 �� ���� boolean �迭 ���� (return�� ���� ���� boolean �迭�� ���� true�� �ٲ���)
		boolean[] check = new boolean[10001];

		// 1���� 10000���� �ݺ��� ���� (���� ����)
		for (int i = 1; i < 10001; i++) {
			int n = d(i);

			if (n < 10001) // �ݺ��� ���� ��� 10000 �ʰ��� ���� �ʿ� ���� ������ if ������ ������
				check[n] = true;
		}

		// StringBuilder : String�� ���ڿ��� ���� �� ���ο� ��ü�� �����ϴ� ���� �ƴ϶� ������ �����͸� ���ϴ� ��� ��� - �� ���ڿ��� ���� �� ����
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (!check[i]) { // boolean �迭 check[]���� false �ε����� ���
				sb.append(i).append('\n'); // append() : ���ڿ��� ������

			}
			System.out.println(sb);
		}
	}

	/*
	 * �־��� ���� number�� int ������ ���Ϲ޴� �Լ� d() �ۼ� (ex.d(75) = 75+7+5 = 87 ����) 
	 * d() �Լ��� �����ϴ� ���� ���� ���� ���� ���� sum ����
	 * 
	 * �Է¹޴� ���� number�� ���Ͽ� while�� ���� number + number�� �����ڸ� �� + number�� 1���ڸ� ��
	 * 
	 * sum ���� (���ϵ� ���� �����ڰ� �ִ� ��, ���ؾ� �ϴ� ���� �����ڰ� ���� self number)
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
