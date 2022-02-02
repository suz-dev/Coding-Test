
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 
 * 이때, 회원들을 나이가 증가하는 순으로, 
 * 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 */
public class N10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[][] st = new String[N][2];

		for (int i = 0; i < N; i++) {
			st[i][0] = sc.next();
			st[i][1] = sc.next();
		}

		Arrays.sort(st, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);

			}

		});

		for (int i = 0; i < N; i++) {
			System.out.println(st[i][0] + " " + st[i][1]);
		}

	}

}