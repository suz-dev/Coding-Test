import java.util.Arrays;
import java.util.Scanner;

public class N1546 {

	/**
	 * 'Arrays.sort()' 메소드를 이용해 최대값 구하기
	 * 'Scanner'를 통해 'double'형 배열 'arr'의 원소를 입력받는다
	 * 새로운 점수의 합을 저장할 'double'형 변수 'total'을 선언한다
	 * 'Arrays'패키지의 'sort()'를 사용하여 정렬한다(오름차순 정렬->최대값은 마지막 원소가 된다)
	 * 반복문을 통해 새로운 점수의 합을 구하여 'total'에 저장한다
	 * 새로운 점수의 평균을 구해야 하기 때문에 점수의 개수를 입력받았던 'arr.lenght'의 값으로 'total'를 나누어 평균을 출력한다
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}
		sc.close();

		double total = 0;
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			total += ((arr[i] / arr[arr.length - 1]) * 100);

		}
		System.out.println(total / arr.length);
	}
}
