import java.util.Arrays;
import java.util.Scanner;

public class N1546 {

	/**
	 * 'Arrays.sort()' �޼ҵ带 �̿��� �ִ밪 ���ϱ�
	 * 'Scanner'�� ���� 'double'�� �迭 'arr'�� ���Ҹ� �Է¹޴´�
	 * ���ο� ������ ���� ������ 'double'�� ���� 'total'�� �����Ѵ�
	 * 'Arrays'��Ű���� 'sort()'�� ����Ͽ� �����Ѵ�(�������� ����->�ִ밪�� ������ ���Ұ� �ȴ�)
	 * �ݺ����� ���� ���ο� ������ ���� ���Ͽ� 'total'�� �����Ѵ�
	 * ���ο� ������ ����� ���ؾ� �ϱ� ������ ������ ������ �Է¹޾Ҵ� 'arr.lenght'�� ������ 'total'�� ������ ����� ����Ѵ�
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}
		sc.close();

		double total = 0;
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			total += ((arr[i] / arr[arr.length - 1]) * 100);

		}
		System.out.println(total / arr.length);
	}
}
