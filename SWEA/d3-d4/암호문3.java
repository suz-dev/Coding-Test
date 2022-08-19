package d3_d4;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // 암호문 길이

			// 암호문 채우기
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}

			int M = sc.nextInt(); // 명령어의 개수
			for (int i = 0; i < M; i++) {

				String func = sc.next(); // I : 삽입 D: 삭제 A : 추가

				// 삽입
				if (func.equals("I")) {
					int X = sc.nextInt(); // 위치
					int Y = sc.nextInt(); // 삽입할 숫자 개수
					for (int j = 0; j < Y; j++) {
						list.add(X + j, sc.nextInt());
					}

					// 삭제
				} else if (func.equals("D")) {
					int X = sc.nextInt(); // 위치
					int Y = sc.nextInt(); // 삭제할 개수
					for (int j = 0; j < Y; j++) {
						list.remove(X);
					}

					// 갱신
				} else {
					int Y = sc.nextInt(); // 추가할 숫자 개수
					for (int j = 0; j < Y; j++) {
						list.add(sc.nextInt());
					}
				}
			}

			System.out.println("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}