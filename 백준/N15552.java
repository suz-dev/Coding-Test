import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15552 {

	/**
	 * 'for'문 단계별 - 빠른 'A+B' 'Scanner'대신 'BufferedReader, BufferedWriter' 사용
	 * 'BufferedReader' 변수 설정, 'input'값은 모두 'BufferedReader.readLine()'으로 받음
	 * 'BufferedWriter' 변수 설정, 'output'값은 모두 'BufferedWriter.write()'으로 받음
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/**
		 * 정수형 변수 'T'를 설정하여 반복횟수 입력받음 
		 * 테스트 케이스로 입력될 두 정수를 받을 'StringTokenizer'메소드 변수'st'추가 
		 * 입력받은 'T'의 반복횟수만큼 반복('for'문) 'StringTokenizer'를 통해 두 정수 입력받음
		 * 'BufferWirter.wirte()'에 두 정수의 합 저장
		 */
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write((Integer.parseInt(st.nextToken())) + Integer.parseInt(st.nextToken()) + "\n");
		}

		/*
		 * 'Scanner'와 마찬가지로 'BufferedReader'와 'BufferedWriter'도 'close()'를 실행해야 함
		 * 'BufferedWriter'의 경우 'buffer flush()'를 통해 남아 있는 데이터를 출력시키고 'close()'해야 함 (버퍼 비우기)
		 */
		br.close();

		bw.flush();
		bw.close();

	}

}
