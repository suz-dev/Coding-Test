package arrays101;

public class FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) {

		int even = 0; // �ڸ����� ������ ¦���� ���
		int cnt = 0; // �ڸ����� ��

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0) { // nums[i]�� 0���� Ŭ ���� �ݺ�
				nums[i] /= 10; // 10�� ������ �ڸ��� ���ϱ�
				cnt++; // 10�� ������ŭ cnt�� +1
			}

			if (cnt % 2 == 0) { // cnt���� ¦���� ��� even++ ����
				even++;
			}
			cnt = 0; // ���� ��Ҹ� ���� cnt ���� 0���� ����
		}

		return even; // ¦�� �ڸ����� ������ ���� even�� ����
	}

}
