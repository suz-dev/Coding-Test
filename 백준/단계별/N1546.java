import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1546 {

	/**
	 * �迭 ���� ���α׷��� �ϱ�
	 * 'BufferedReader'�� ���� �Է� ���� 'N'�� �Է¹޴´�
	 * 'StringTokenizer'�� ���� 'BufferedReader.readLine()'���� �Է¹޴� ���� �������� �����Ѵ�
	 * 
	 * �ִ밪�� ������ ���� 'max'�� �����ϰ� -1�� �ʱ�ȭ�����ش�
	 * ������ ���� ������ 'double'�� ���� 'sum'�� ������ �� 0���� �ʱ�ȭ�����ش�
	 * 
	 * �ݺ����� ���� 'N'�� ���� ������ �Է¹޴´�
	 * 'if'���� ���� �Է¹��� ���� 'max'���� Ŭ ��� 'value'�� 'max'�� �����Ѵ�
	 * �ݺ����� ����� ���� 'value'���� 'sum'�� �����ش� (����� �ϳ��� ������ �ʰ�, ������ ���� ���� �� �ѹ��� �����Ѵ�)
	 * 
	 * ���ο� ��հ��� ����Ѵ�
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int max = -1;
		double sum = 0;

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());

			if (value > max) {
				max = value;
			}
			sum += value;
		}
		System.out.println(((sum / max) * 100 / N));
	}
}
