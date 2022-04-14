package Level1;

public class 문자열내p와y의개수 {

	boolean solution(String s) {

		int pCount = 0;
		int yCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.toUpperCase().charAt(i) == 'P') {
				pCount++;
			} else if (s.toUpperCase().charAt(i) == 'Y') {
				yCount++;
			}
		}

		return pCount == yCount;
	}
}
