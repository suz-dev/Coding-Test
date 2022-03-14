import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 배열 오름차순 정렬
public class N2750 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}
		
		// Bubble sort
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}

			}

		}
		
		for (int val : arr) {
			System.out.println(val);
		}
	}

}
