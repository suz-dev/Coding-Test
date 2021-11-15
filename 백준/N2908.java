import java.util.Scanner;

public class N2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int[] arr = new int[2];
		
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			int A = sc.nextInt();
			arr[i] = (A % 10) * 100 + ((A / 10) % 10) * 10 + (A / 100);

			if (arr[i] > max) {
				max = arr[i];
			}
		}
		sc.close();
		System.out.println(max);
	}

}
