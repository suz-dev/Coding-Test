import java.util.Scanner;

public class N1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 	// �Է¹��� ���� ����
		int cnt = 0; 			// k�� ����� ����
		int p = 0; 				// �Ҽ��� ����

		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			for (int j = 1; j <= k; j++) { // �Է¹��� �� k�� 1~k�� ������ ����� ������ ���ϴ� �ݺ���
				if (k % j == 0) {
					cnt++; // ����� ���� cnt++
				}
			}
			if (cnt == 2) { // ����� ������ 2�� ��(�Ҽ�)
				p++; 		// �Ҽ��� ���� +1
				cnt = 0; 	// ���� ���� ����� ���� cnt�� 0���� ����
			} else { 		// �Ҽ��� �ƴ� ��
				cnt = 0; 	// cnt = 0
			}

		}
		System.out.println(p); // �Ҽ��� ���� p ���
	}
}
