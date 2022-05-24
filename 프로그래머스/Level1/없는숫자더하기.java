package Level1;

import java.util.Arrays;
import java.util.List;

public class 없는숫자더하기 {
	public int solution(int[] numbers) {
		int answer = 0;

		Integer Numbers[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		List<Integer> list = Arrays.asList(Numbers);

		for (int i = 1; i <= 9; i++) {

			if (!list.contains(i)) {
				answer += i;
			}
		}

		return answer;
	}
}