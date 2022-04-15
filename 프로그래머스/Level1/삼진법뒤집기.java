package Level1;

public class 삼진법뒤집기 {
	public int solution(int n) {

		String str = Integer.toString(n, 3);
		StringBuilder sb = new StringBuilder();

		return Integer.parseInt(sb.append(str).reverse().toString(), 3);

	}
}