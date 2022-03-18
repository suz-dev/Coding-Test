package Kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 참조  https://jangcenter.tistory.com/116

public class 신고결과받기 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		// 사용자id-신고한 사용자id의 set을 가진 맵(동일유저에 대한 신고횟수는 1로 처리, 중복X)
		Map<String, HashSet<String>> map = new HashMap<>();
		// 사용자id-임의의 인덱스
		Map<String, Integer> idxMap = new HashMap<>();

		// Map 초기화
		for (int i = 0; i < id_list.length; i++) {
			String name = id_list[i];
			map.put(name, new HashSet<>());
			idxMap.put(name, i);
		}

		// "사용자id 신고한id"로 입력이 주어짐 (split(" ")을 이용해 구분)
		for (String s : report) {
			String[] str = s.split(" ");
			String from = str[0];
			String to = str[1];
			map.get(to).add(from);
		}

		// 이용자 정지 메일 발송
		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> send = map.get(id_list[i]);
			if (send.size() >= k) {
				for (String name : send) {
					answer[idxMap.get(name)]++;
				}
			}
		}
		return answer;
	}

}
