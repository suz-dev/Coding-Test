import java.util.Scanner;

public class N10950 {

	public static void main(String[] args) {
	
	/** ������ �ݺ��� Ƚ�� �Է¹ޱ�
	 * 'Scanner' ����
	 * 'int T': �ݺ� Ƚ�� �Է°� ����
	 * 'int[] answer': ���� ����� ���� ����
	 */

		System.out.println("�ݺ�Ƚ���� �Է��Ͻÿ�.");
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] answer = new int[T];

	
	/** ������ �Է��� Ƚ�� ��ŭ ������ �� �� �Է��ϱ�(�ݺ���)
	 * ����'a, b' �Է¹ޱ�
	 * 'answer'�� ����� ���ʴ�� ����
	 * 'Scanner' ����
	 */

		System.out.println("���� a�� b�� �Է��Ͻÿ�. ��) 1 2");
		for (int i = 0; i < answer.length; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			answer[i] = a + b;
		}
		scanner.close();

	/** ���� ���� �� ��� ������ ���(�ݺ���)
	 * �迭 'answer'�� ��� ����ŭ �ݺ�����
	 * 'int k': 'answer'�� �� ��Ұ� �Ҵ�� ������ ����
	 */
		
		System.out.println("��: ");
		for (int k : answer) {
			System.out.println(k);
		}
	}

}
