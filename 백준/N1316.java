import java.util.Scanner;
 
public class N1316 {
 
	// ���� : https://st-lab.tistory.com/69 - boolean �Լ� �̿�
	static Scanner sc = new Scanner(System.in);
 
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
	 * �ܾ üũ�� boolean Ÿ�� �Լ�
	 */
	public static boolean check() {
		boolean[] check = new boolean[26]; // boolean �迭 ����
		int prev = 0; // ���� ���� �Ǻ� ����
		String str = sc.next();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);	// i ��° ���� ���� (���� ����)
						
			// �ռ� ���ڿ� i ��° ���ڰ� ���� �ʴٸ�?
			if (prev != now) {		
				
				// �ش� ���ڰ� ó�� ������ ��� (false �� ���)
				if ( check[now - 'a'] == false ) {
					check[now - 'a'] = true;		// true �� �ٲ��ش�
					prev = now;					// ���� ���� ���� prev �� �ٲ��ش� 
				}
	 
				// �ش� ���ڰ� �̹� ���� ���� �ִ� ��� (�׷�ܾ �ƴϰ� ��) 
				else {
					return false;	//�Լ� ����
				}
			}
	                
			// �ռ� ���ڿ� i ��° ���ڰ� ���ٸ�? (���ӵ� ����)
			// else ���� ��� ��
			else {
				continue;
			}
		}    
		return true;
	}
}