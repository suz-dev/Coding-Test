import java.util.Scanner;

public class N1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		int[] arr = new int[k];
		int max = arr[0];
		double total = 0;

		for (int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		sc.close();
		
		for (int i = 0; i < k; i++) {
			total += (((double) arr[i] / max) * 100);

		}
		System.out.printf("%.2f", total / k);
	}

}
