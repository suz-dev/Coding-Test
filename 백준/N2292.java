import java.util.Scanner;

public class N2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // �Է� ��

		int cnt = 1; // N���� ������ �� ���� (��)

		int range = 2; // ���� �ּڰ�

		if (N == 1) {
			System.out.println(1);
		} else {
			while (range <= N) { // N���� Ŀ���� �������� �ݺ�
				range = range + (cnt * 6);
				cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
