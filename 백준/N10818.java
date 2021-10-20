import java.util.Arrays;
import java.util.Scanner;

public class N10818 {

	/**
	 * 'N'���� ������ �־��� �� �迭�� �̿��Ͽ� �ִ񰪰� �ּڰ� ���ϱ�
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'�� �̿��Ͽ� �Է¹��� ������ ���� ���� �Է¹��� (N)
		 * ���̰� 'N'�� �迭 ����
		 * �迭�� �� 'N'���� ������ �Է¹���
		 * 'Arrays.sort()'�޼ҵ带 ���� �ּڰ��� �ִ� ���ϱ�
		 */

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[N - 1]);
	}
}