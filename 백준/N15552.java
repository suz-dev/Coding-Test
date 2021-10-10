import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15552 {

	/**
	 * 'for'�� �ܰ躰 - ���� 'A+B' 'Scanner'��� 'BufferedReader, BufferedWriter' ���
	 * 'BufferedReader' ���� ����, 'input'���� ��� 'BufferedReader.readLine()'���� ����
	 * 'BufferedWriter' ���� ����, 'output'���� ��� 'BufferedWriter.write()'���� ����
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/**
		 * ������ ���� 'T'�� �����Ͽ� �ݺ�Ƚ�� �Է¹��� 
		 * �׽�Ʈ ���̽��� �Էµ� �� ������ ���� 'StringTokenizer'�޼ҵ� ����'st'�߰� 
		 * �Է¹��� 'T'�� �ݺ�Ƚ����ŭ �ݺ�('for'��) 'StringTokenizer'�� ���� �� ���� �Է¹���
		 * 'BufferWirter.wirte()'�� �� ������ �� ����
		 */
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write((Integer.parseInt(st.nextToken())) + Integer.parseInt(st.nextToken()) + "\n");
		}

		/*
		 * 'Scanner'�� ���������� 'BufferedReader'�� 'BufferedWriter'�� 'close()'�� �����ؾ� ��
		 * 'BufferedWriter'�� ��� 'buffer flush()'�� ���� ���� �ִ� �����͸� ��½�Ű�� 'close()'�ؾ� �� (���� ����)
		 */
		br.close();

		bw.flush();
		bw.close();

	}

}
