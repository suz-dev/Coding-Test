import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 택시기하학 원의 넓이 구하기
public class N3053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int R = Integer.parseInt(br.readLine());

		double Euclid = Math.pow(R, 2) * Math.PI;
		double Taxicap = Math.pow(R, 2) * 2;

		System.out.printf("%.6f%n", Euclid);
		System.out.printf("%.6f%n", Taxicap);
	}

}
