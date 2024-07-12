import java.util.*;
import java.io.*;

public class Main {

    static String pattern = "";
    static String re = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String answer = "라고 답변하였지.";

    static String[] script = {"\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

    public static void solution(int N){
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(0, N);
        System.out.println(answer);
    }

    public static void recursion(int depth, int N){
        if(depth == N){

            System.out.println(pattern + script[0]);
            System.out.println(pattern + re);

            return;
        }

        for(String s : script){
            System.out.println(pattern + s);
        }

        pattern += "____";
        recursion(depth + 1, N);

        System.out.println(pattern + answer);
        pattern = pattern.substring(0, pattern.length() - 4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solution(N);
    }
}