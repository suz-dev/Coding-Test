import java.util.Scanner;

public class N11720 {

	/*
	 * ������ ���� 'N'�� �Է¹޴´�
	 * ������� 'N'���� ���ڸ� 'String'���� �Է¹޴´�
	 * 
	 * ������ ���ڸ� ���� ���� 'sum'�� �����Ѵ�
	 * 
	 * 'for'���� ���� ���ڿ��� �Է¹��� ������ ���Ҹ� 'charAt(0)' ~ 'charAt(N)'���� ���� �հ踦 ���Ѵ�
	 * 'charAt()'�� �ش� ������ �ƽ�Ű �ڵ带 ��ȯ�ϹǷ� '-48' �Ǵ� '0'�� ����Ͽ� ����ؾ� �Ѵ� (�������)
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
