import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		char[] ch = N.toCharArray();

		Arrays.sort(ch);

		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

}
