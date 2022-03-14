import java.util.Scanner;

public class N4344 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int arr[];
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			arr = new int[sc.nextInt()];

			double sum = 0;

			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}

			double avg = (sum / arr.length);
			double cnt = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", (cnt / arr.length) * 100);
		}
		sc.close();
	}
}
