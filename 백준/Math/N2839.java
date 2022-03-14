import java.util.Scanner;

// re
public class N2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // ����� ���� kg

		int cnt = 0; // ���� ����

		while (true) {

			/*
			 * N�� 5�� ������ ������ �� ���� ���� ������ ������ ��
			 * 'N/5'�� �� �ٷ� ��� �� �ݺ��� ��������
			 * 
			 * 'N % 5 != 0'�� ��� N���� 3��ŭ ���� ���� cnt++ �� �ݺ�
			 *  N�� 0�� �Ǹ� ù��° �ݺ������� ���ư� cnt ���
			 * 
			 * 'N -= 3'�� ���� 'N < 0'�� �ȴٸ� '-1'��� �� break
			 */

			if (N % 5 == 0) {
				cnt += N / 5;
				System.out.println(cnt);
				break;
			} else {
				N -= 3;
				cnt++;
			}

			if (N < 0) {
				System.out.println(-1);
				break;
			}
		}
		sc.close();
	}

}
