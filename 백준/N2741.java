import java.util.Scanner;

/**
 * �ڿ��� 'N'�� �־����� ��, 1���� 'N'���� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * 'for'�� ���
 */
public class N2741 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		for (int i = 1; i <= N; i++) {
			System.out.println(i);
		}
	}

}
