package Kakao;

import java.util.Arrays;

public class 실패율 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double[][] cnt = new double[N + 1][3];

		// stage별 머물러있는 사용자 수
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] > N)
				continue;
			cnt[stages[i]][0]++;
		}

		cnt[1][1] = stages.length;
		cnt[1][2] = 1;

		for (int i = 2; i < cnt.length; i++) {

			// i스테이지에 도달한 사람의 수 = 이전 스테이지에 도달한 사람의 수 - 이전 스테이지에 머무르는 사람 수
			cnt[i][1] = (int) (cnt[i - 1][1] - cnt[i - 1][0]);
			cnt[i][2] = i; // 스테이지 정보 매칭
		}

		for (int i = 1; i < cnt.length; i++) {
			// 각 스테이지에 도달한 사람이 없을 경우 : 실패율 0
			if (cnt[i][1] == 0) {
				cnt[i][0] = 0;
				continue;
			}
			// 실패율 = 스테이지에 머무르는 사람의 수 / 스테이지에 도달한 사람의 수
			cnt[i][0] = cnt[i][0] / cnt[i][1];
		}

		Arrays.sort(cnt, (o1, o2) -> {
			// 0번 인덱스 무시
			if (o1[2] == 0 || o2[2] == 0)
				return 0;
			// 실패율이 같을 경우, 스테이지 오름차순 정렬
			if (o1[0] == o2[0])
				return Double.compare(o1[2], o2[2]);
			// 실패율이 다를 경우, 실패율에 따라 내림차순 정렬
			else
				return Double.compare(o2[0], o1[0]);
		});

		for (int i = 1; i < cnt.length; i++) {
			answer[i - 1] = (int) cnt[i][2];
		}

		return answer;
	}
}