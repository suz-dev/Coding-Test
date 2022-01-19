import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 배열 정렬 - 시간복잡도 O(logn) : Collections.sort 사용
public class N2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 배열은 list계열 중 하나 사용
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		for (int value : list) {
			sb.append(value).append('\n');
		}

		System.out.println(sb);
	}
}
