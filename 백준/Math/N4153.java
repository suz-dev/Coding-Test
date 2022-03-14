import java.util.Arrays;
import java.util.Scanner;

// 직각삼각형 여부 확인
public class N4153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] triangle = new int[3];

		while (true) {

			for (int i = 0; i < triangle.length; i++) {
				triangle[i] = sc.nextInt();
			}

			Arrays.sort(triangle);

			if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
				break;
			} else if (Math.pow((double) triangle[0], 2) + Math.pow((double) triangle[1], 2) == Math
					.pow((double) triangle[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}

}
