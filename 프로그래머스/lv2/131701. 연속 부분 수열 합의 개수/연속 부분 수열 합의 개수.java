import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
   		Set<Integer> set = new HashSet<>();
		
		int n = 0;
		while(n <= elements.length) {
			for(int i = 0; i < elements.length; i++) {
				int sum = 0;
				
				for(int j = i; j < i + n; j++) {
					sum += elements[j % elements.length];
				}
				set.add(sum);
			}
			n++;
		}
		return set.size() - 1;
    }
}