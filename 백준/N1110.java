import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1110 {

	/**
	 * 100 �̸��� ���� �Է¹޾� ����Ŭ�� ���̸� ���Ͻÿ�
	 * 
	 * 1) �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�. 
	 * 2) �־��� ���� ���� ������ �ڸ����� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. 
	 * 3) �־��� ���� ���ƿ� �� ����Ŭ�� ������.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 'BufferedReader'�� ���� ���� 'k'�� �Է¹޴´� 
		 * 'do~while'������ �Է°� 'k'�� ���� ���� 'copy'�� �����Ѵ�
		 * ����Ŭ�� ���̸� ��Ÿ�� ���� 'count'�� �����Ѵ�
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		br.close();

		int copy = k;
		int count = 0;

		/**
		 * ���� �ڸ����� ���� �ڸ����� ������ ����Ŭ�� ���� ���ο� ���� �Է¹޴� ���� �ۼ��Ѵ� 
		 * �����ڸ�(k / 10) �����ڸ�(k % 10) 
		 * ù��° ����Ŭ���� �� �ڸ����� ���ڸ� ���� ���� �����ڸ��� ���� ������ �����ڸ��� �����ϰ�, ���� ������ �����ڸ��� �����ڸ��� �����Ͽ� ���ο� ���ڸ� ����� 
		 * 'copy == k'�� �� ������ �ݺ��Ѵ� �ݺ��� ����Ŭ�� ���̸� ����Ѵ�
		 */

		do {

			k = ((k % 10) * 10) + (((k / 10) + (k % 10)) % 10);
			count++;

		} while (copy != k);

		System.out.println(count);
	}

}
