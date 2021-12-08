import java.util.Scanner;

// re
public class N1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt(); // 입력받을 수 (순서)
		
		int cross_count = 1; // 해당 범위 대각선 개수
		int prev_count_sum = 0; // 직전 대각선 까지 칸의 누적 합
		
		while(true) {
			
			// 직전 대각선 누적합 + 해당 대각선 개수 이용 범위 판별
			if (X <= prev_count_sum + cross_count) {
				
				if(cross_count % 2 == 1) { // 대각선 개수가 홀수일 때 (홀/짝 진행방향이 다름)
					
					/*
					 * 분모가 큰 수부터 시작
					 * 분모 : 대각선 개수 - (X번째 - 직전 대각선까지의 누적합 - 1)
					 * 분자 : X번째 - 직전 대각선까지의 누적합
					 */
					System.out.print((cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
					break;
				}else { // 대각선 개수가 짝수일 때 (홀수와 반대로 출력)
					System.out.print((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
					break;
				}
			}else {
				prev_count_sum += cross_count;
				cross_count++;
			}
		}
		sc.close();
	}

}
