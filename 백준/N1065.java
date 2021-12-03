import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �Ѽ�(�� �ڸ����� ������ �̷�� ��) ����

public class N1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(arithmetic_sequence(Integer.parseInt(br.readLine())));

	}

	public static int arithmetic_sequence(int num) {

		int cnt = 0;

		if (num < 100) { // ���ڸ� ���� ��� �Ѽ�

			return num;

		} else {

			cnt = 99;

			if (num == 1000) { // ����ó��
				num = 999;
			}

			for (int i = 100; i <= num; i++) {

				int hun = i / 100; // ���� �ڸ���
				int ten = (i / 10) % 10; // ���� �ڸ���
				int one = i % 10; // ���� �ڸ���

				if ((hun - ten) == (ten - one)) { // �� �ڸ����� ������ �̷�
					cnt++;
				}
			}
		}

		return cnt;

	}
}
