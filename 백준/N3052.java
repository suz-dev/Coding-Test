import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3052 {

	/**
	 * �� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���� ����, ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * �������� ������ ���� �� �ִ� 0 ~ 41 ������ ���� �� �ִ� 'boolean'�迭 'arr'�� �����Ѵ�('boolean'�迭�� 'default'���� 'false'�̴�) 
		 * 'BufferedReader'�� ���� ���ڸ� �Է¹޴´�
		 * �ݺ����� �����Ͽ� �Է¹��� ���� %42�� ������ ���� 'index'�� 'true'�� �ٲ��ش� 
		 * �ݺ��� ���� �� ������ ������ ���� 'count'�� ������ �� ���� �ݺ����� �����Ͽ� ù��° �ݺ������� 'true'�� �ٲ��� ���� ���Ͽ� 'count++'�� �����Ѵ� 
		 * �ݺ��� ���� �� 'count'���� ����Ѵ�
		 */

		boolean[] arr = new boolean[42];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true;
		}

		int count = 0;

		for (boolean value : arr) {
			if (value) {
				count++;
			}
		}
		System.out.println(count);
	}

}
