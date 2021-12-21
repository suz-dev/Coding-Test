
public class DuplicateZero {
	
	//Input: arr = [1,0,2,3,0,4,5,0]
	//Output: [1,0,0,2,3,0,0,4]
	//Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

	public void duplicateZeros(int[] arr) {

		// arr[i]�� ��Ҹ� ��ĭ�� �ڷ� �о�� �ϱ� ������ ���̴� arr.length-1 �� ����
		for (int i = 0; i < arr.length - 1; i++) {
 
			/*
			 * arr[i] == 0 �� ��츸 ����
			 * arr[3]�� ��� arr.length = 4 �̱� ������ j = arr.length - 2 �� �ʱ�ȭ�Ѵ�
			 * �ݺ����� ���� arr[j + 1]�� ��Һ��� arr[j] ��ұ��� ��ĭ�� �ڷ� �̵���Ų��
			 * ����̵��� ������ i++�� ������ �� ����ִ� arr[i]�� 0�� �־��ش�
			 */
			if (arr[i] == 0) {
				for (int j = arr.length - 2; j > i; j--) {
					arr[j + 1] = arr[j];
				}
				i++;
				arr[i] = 0;
			}
		}
	}

}

