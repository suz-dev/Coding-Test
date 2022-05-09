import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// �鸸 ���� ������Ʈ
public class N1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = br.read(); // TC ����
		for (int i = 1; i <= T; i++) {
			int N = br.read(); // ���� ���� ���� ���� �ϼ�
			String[] S = br.readLine().split(" ");

			System.out.println("#" + i + " " + Days(N, S));
		}
	}

	public static Long Days(int n, String[] s) {
		Long cost = 0L;

		Queue<Integer> que = new LinkedList<Integer>();
		for (String i : s) {
			que.add(Integer.parseInt(i));
		}

		int max = 0;	// �Ǹ� �ִ밡
		for (int i : que) {
			max = Math.max(max, i);
		}

		while (!que.isEmpty()) {

			if (que.peek() < max) {
				cost += max - que.poll(); // �ǸŰ� - ���Ű�
			} else if (que.peek() == max) {
				que.poll();
				for (int i : que) { // max�� �缳��
					max = Math.max(max, i);
				}

			}
		}

		return cost;
	}

}
