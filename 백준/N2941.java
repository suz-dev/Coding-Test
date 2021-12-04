import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		int cnt = 0; 

		for (int i = 0; i < S.length(); i++) {

			char ch = S.charAt(i);

			if (ch == 'c') { // c=, c-

				if (i < S.length() - 1) {
					if (S.charAt(i + 1) == '=' || S.charAt(i + 1) == '-') {

						i++;
					}
				}

			} else if (ch == 'd') { // dz=, d-

				if (i < S.length() - 1) {
					if (S.charAt(i + 1) == 'z') {
						if (i < S.length() - 2) {
							if (S.charAt(i + 2) == '=') {
								i += 2;
							}
						}

					} else if (S.charAt(i + 1) == '-' || S.charAt(i + 1) == '=') {
						i++;
					}
				}

			} else if (ch == 's' || ch == 'z') { // s=, z=

				if (i < S.length() - 1) {
					if (S.charAt(i + 1) == '=') {
						i++;
					}
				}

			} else if (ch == 'l' || ch == 'n') { // lj, nj

				if (i < S.length() - 1) {
					if (S.charAt(i + 1) == 'j') {

						i++;
					}
				}

			}
			cnt++;
		}

		System.out.println(cnt);

	}

}
