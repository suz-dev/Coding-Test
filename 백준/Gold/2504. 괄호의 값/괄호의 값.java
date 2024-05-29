import java.io.*;
import java.util.*;

public class Main {
    public static int solution(String s){
        int answer = 0;

        ArrayList<Character> left = new ArrayList<>(Arrays.asList('(', '['));
        ArrayList<Character> right = new ArrayList<>(Arrays.asList(')', ']'));

        Map<Character, char[]> pair = new HashMap<>();
        pair.put(')', new char[]{'(', '2'});
        pair.put(']', new char[]{'[', '3'});

        // 종료
        if(s.length() % 2 == 1 || right.contains(s.charAt(0)) || left.contains(s.charAt(s.length() - 1))) return 0;

        Stack<Character> stack = new Stack<>();
        int cal = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(left.contains(ch)) { // ( , [
                // 초기화
                if(cal > 1) {
                    stack.push((char)(cal + '0'));
                    cal = 1;
                }

                stack.push(ch);
            }else { // ), ]
                if(stack.isEmpty()) return 0;

                char pre = stack.peek();
                if(pre == pair.get(ch)[0]){
                    // 짝 맞음
                    cal *= pair.get(ch)[1] - '0';
                    stack.pop();

                    // 묶음 종료
                    if(stack.isEmpty()) {
                        answer += cal;
                        cal = 1;
                    }
                    
                }else { // 숫자 
                    if(left.contains(pre)) return 0;

                    // 덧셈 수행
                    int sum = 0;
                    while(!left.contains(pre)){
                        sum += pre - '0';
                        stack.pop();
                        pre = stack.peek();
                    }
                    
                    // 더할 값 존재
                    if(cal > 1) sum += cal;

                    // 괄호 check
                    pre = stack.pop();
                    if(pre != pair.get(ch)[0]) return 0;

                    cal = pair.get(ch)[1] - '0';
                    if(!stack.isEmpty()) {
                        int tmp = sum * cal;
                        stack.push((char)(tmp + '0'));
                    }else{  // 한 묶음 종료
                        answer += (sum * cal);
                    }

                    cal = 1;    // 초기화
                }
            }
        }

        if(!stack.isEmpty()) return 0;
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().strip();

        System.out.println(solution(s));
    }
}