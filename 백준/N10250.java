import java.util.Scanner;

public class N10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = 0; // ���� ��
		int w = 0; // ���� ȣ��

		int T = sc.nextInt(); // �׽�Ʈ���̽� ����

		for (int i = 0; i < T; i++) {

			int H = sc.nextInt(); // ȣ���� �� ��
			int W = sc.nextInt(); // �� ���� �� ��
			int N = sc.nextInt(); // �� ��° �մ�

			if (N % H != 0) {
				h = (N % H);
				w = (N / H) + 1;

			} else {
				h = H;
				w = N / H;
			}

			System.out.println((100 * h) + w);
		}

	}

}
