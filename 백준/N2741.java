import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �ڿ��� 'N'�� �־����� ��, 1���� 'N'���� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * 'BufferedReader' ���
 */
public class N2741 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(i);
		}
		
	}

}
