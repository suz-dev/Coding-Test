import java.util.Arrays;
import java.util.Scanner;

public class N1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 한수 위치 (x,y)
		int x = sc.nextInt();
		int y = sc.nextInt();

		// 직사각형의 오른쪽 위 꼭지점
		int w = sc.nextInt();
		int h = sc.nextInt();

		int[] arr = { x, y, w - x, h - y };

		Arrays.sort(arr);

		System.out.println(arr[0]);

	}

}
