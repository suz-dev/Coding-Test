
/*
 * �Է�
 * - ���ڰ� �Ϻ� ������ �ζ� ��ȣ �迭 (������ ���ڴ� 0���� ǥ��) : int[] lottos
 * - ��÷ �ζ� ��ȣ : int[] win_nums
 * 
 * ����
 * - lottos�� 0�� �ƴ� ��ҿ� win_nums�� ��� �� : ���ٸ� zeroCnt + 1
 * - 0�� �����ϰ� �������� ��ġ�ϴ� ������ ���� = min
 * - min + zeroCnt�� �迭�� ���� = max
 * - switch case ������ ��� �̱� (lottoRank)
 * 
 * ���
 * - �ְ����� ��������� ���� answer�� ��� return
 * 
 */
public class �ζ�_�ְ����_�������� {

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int zeroCnt = 0;
		int min = 0;
		for (int i : lottos) {
			if (i == 0) {
				zeroCnt++;
				continue;
			}
			for (int j : win_nums) {
				if (i == j)
					min++;
			}
		}

		answer[0] = lottoRank(zeroCnt + min);
		answer[1] = lottoRank(min);

		return answer;
	}

	public int lottoRank(int n) {
		switch (n) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
