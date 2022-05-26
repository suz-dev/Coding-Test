package Level1;

import java.util.Arrays;
import java.util.List;

// 효율성 
public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);

		List<String> list = Arrays.asList(participant);
		List<String> list2 = Arrays.asList(completion);

		int a = list2.size();
		int b = list.size() - 1;

		for (int i = 0; i < a; i++) {
			if (!list2.get(i).equals(list.get(i))) {
				b = i;
				break;
			}
		}

		answer = list.get(b);

		return answer;

	}
}