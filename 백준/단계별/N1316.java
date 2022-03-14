import java.util.Scanner;

public class N1316 {

	// ���� : https://st-lab.tistory.com/69 - boolean �Լ� �̿�
	static Scanner sc = new Scanner(System.in);

	/*
	 * check()�� ���� true ���� ��ȯ�� �ܾ��� ������ ������ ���� count 
	 * �Է¹��� �ܾ��� ���� N
	 * 
	 * N��ŭ�� �ݺ��� ���� check()�� ���ϰ��� true �� ��, 
	 * count++ ����
	 * 
	 * count�� ���
	 */

	public static void main(String[] args) {

		int count = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	 * �ܾ üũ�� boolean Ÿ�� �Լ� check()
	 * 
	 * boolean �迭 ���� ('a'-'z' ���� �迭) 
	 * ���ӵ� ���ڸ� �Ǻ��� ���� prev ���� 
	 * next()�� ���� ���ڿ� �Է¹���
	 * 
	 * ���ڿ��� ���̸�ŭ �ݺ��� ���� 
	 * ���ڿ��� �� ���ڸ� ������ ������ ���� now ���� (���� ����)
	 */
	public static boolean check() {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);

			/*
			 * �ռ� ���� =/= ���� ����(i��° ����)
			 * 
			 * - �ش� ���ڰ� ó�� ������ ��� (false) 
			 * �ش� �迭�� ���� true ������ �ٲ��ش� 
			 * prev���� now ������ ��ü
			 * 
			 * - �ش� ���ڰ� �̹� ���� ���� �ִ� ��� (check[now - 'a'] == true �� ��) 
			 * false ���� (�Լ� ����)
			 * 
			 * �ռ� ���� = ���� ����(i) - ���ӵ� ������ �� 
			 * continue;
			 * 
			 * true �� ����
			 */
			if (prev != now) {

				if (check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				}

				else {
					return false;
				}
			}

			else {
				continue;
			}
		}
		return true;
	}
}