import java.util.Scanner;

public class N11654 {
	
	/*
	 * 'Scanner'로 문자를 입력받을 때에는 'nextLine() / next()'를 통해 입력받아 'charAt()'를 이용하여 문자로 잘라준다
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int c = sc.next().charAt(0);
		sc.close();
		
		System.out.println(c);

	}

}
