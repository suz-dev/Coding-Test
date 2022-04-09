package Level1;

import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {

	public Set<Integer> solution(int[] numbers) {

		// TreeSet 중복제거 + 오름차순 정렬
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		return set;
	}
}
