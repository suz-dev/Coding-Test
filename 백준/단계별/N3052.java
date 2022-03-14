import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N3052 {

	/**
	 * �� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���� ����, ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 'HashSet'�� ����Ͽ� �迭 ���� ���α׷��� �ϱ� ('Set'�� �Ļ�Ŭ������ ���������� ���� �ߺ��� ������� ����)
		 * 'BufferedReader'�� ���� ���ڸ� �Է¹޴´�
		 * 'HashSet<Integer>'�� ����Ÿ���� ���� 'h'�� �����Ѵ�
		 * �ݺ����� �����Ͽ� 'HashSet.add()'�޼ҵ带 ���� �Է¹��� ������ 42�� ���� ���������� 'HashSet'�� �����Ѵ�
		 * �ߺ����� ���� ��� 'True', �ߺ����� ���� ��� �������� �ʰ� 'False'�� ��ȯ�Ѵ�
		 * 
		 * �ݺ����� �������� 'HashSet'�� ũ�⸦ ��ȯ�ϴ� 'HashSet.size()'�� ���� ����Ѵ�
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> h = new HashSet<Integer>();

		for (int i = 0; i < 10; i++) {
			h.add(Integer.parseInt(br.readLine()) % 42);
		}

		System.out.println(h.size());
	}

}
