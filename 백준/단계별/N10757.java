import java.math.BigInteger;
import java.util.Scanner;

// long 범위를 벗어나는 큰 수 연산
public class N10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());

		A = A.add(B);

		System.out.println(A.toString());
	}

}
