import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2741 {
	
	/**
	 * 'for'�� ���� 'A+B' �߰�����
	 * �� �׽�Ʈ ���̽����� "Case #x: A + B = C" �������� ����Ѵ�. 
	 * x�� �׽�Ʈ ���̽� ��ȣ�̰� 1���� �����ϸ�, 'C = A+B'�̴�.
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/** 
		 * ������ ���� 'a', 'b' �߰�
		 */
		int T = Integer.parseInt(br.readLine());
		int a;
		int b;

		StringTokenizer st = null;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			bw.write("Case #" + (i + 1) + ": " + a + " + " + b + " = " + (a + b));
			bw.newLine();
		}

		br.close();

		bw.flush();
		bw.close();

	}

}
