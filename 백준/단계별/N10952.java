import java.util.Scanner;

public class N10952 {

	/**
	 * 10952 -> 10951 �Է°��� 0���� ������ ���� ��, ���̻� ���� �� ���� ������(EOF)�� ���� �� ����
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(a + b);

		}
		sc.close();

	}
}


