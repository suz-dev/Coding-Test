package Level1;

import java.util.Arrays;
import java.util.HashSet;

public class 폰켓몬 {
	public int solution(int[] nums) {

		Integer[] Nums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(Nums));

		return hashSet.size() <= nums.length / 2 ? hashSet.size() : nums.length / 2;

	}
}