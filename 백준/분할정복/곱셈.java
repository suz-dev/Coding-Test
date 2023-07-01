package 백준.boj_230701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
분할정복
지수 법칙 : a^(n+m) = a^n * a^m
모듈러 연산 : (a*b) mod C = (a mod C * b mod C) mod C
-> (a * b) % C = (a % C * b % C) % C
 */
public class 곱셈 {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b));
    }

    public static long pow(long A, long exponent) {

        // 지수가 1일 경우 A^1 = A
        if (exponent == 1) {
            return A % C;
        }

        // 지수의 절반
        long tmp = pow(A, exponent / 2);

        // 지수가 홀수일 때
        // A^(exponent/2) * A^(exponent/2) * A
        // A^9 = A^4 * A^4 *A
        if (exponent % 2 == 1) {
            return (tmp * tmp % C) * A % C;
        }

        return tmp * tmp % C;
    }
}
