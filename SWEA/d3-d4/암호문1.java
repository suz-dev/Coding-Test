package d3_d4;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // 원문 암호문의 길이

			// 원문 암호문 입력받기
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}

			int cmdN = sc.nextInt(); // 명령어 개수
			for (int i = 0; i < cmdN; i++) {

				String start = sc.next(); // I
				int x = sc.nextInt(); // x (idx+1)에 삽입
				int y = sc.nextInt(); // y

				for (int j = 0; j < y; j++) {
					list.add(x + j, sc.nextInt());
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}