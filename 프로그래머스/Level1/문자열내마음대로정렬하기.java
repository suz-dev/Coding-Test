package Level1;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
		
		Arrays.sort(strings, (String o1, String o2) -> {

			if (o1.charAt(n) > o2.charAt(n)) {
				return 1;
			}else if(o1.charAt(n) == o2.charAt(n)) {
				return o1.compareTo(o2);
			}else {
				return -1;
			}

		});

		return strings;
	}
}