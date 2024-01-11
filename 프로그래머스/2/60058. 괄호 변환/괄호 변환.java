import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = divide(p);
        
        return answer;
    }
    
    // u, v 나누기 
    // u + v 해서 String return
    public static String divide(String w){
        if(w.length() == 0) return "";
        
        String u = "";
        String v = "";

        int idx = 0;
        int a = 0;
        int b = 0;
        for(int i = 0; i < w.length(); i++){
            char ch = w.charAt(i);
            
            if(ch == '(') a++;
            else b++;     

            if(a == b) {
                idx = a + b;
                break;
            }
        }
        
        // u, v 분리
        u = w.substring(0, idx);
        if(idx < w.length()) v = w.substring(idx, w.length());
        
        // u 올바른 괄호 아니면 올바르게 바꾸기
        // 앞뒤 괄호 빼고 나머지 반대방향으로 바꿔서 앞뒤 ( ) 붙이기
        // if(!check(u)) u = change(u);
        if(check(u)) return u + divide(v);
        
        // v 올바른 괄호 아니면 재귀
        return "(" + divide(v) + ")" + change(u);
    }
    
    // changeU
    public static String change(String u){
        if(u.isEmpty()) return "";

        String tmp = "";
        for(int i = 1; i < u.length() - 1; i++){
            char ch = u.charAt(i);
            
            if(ch == ')') tmp += '(';
            else tmp += ')';
        }
        
        return tmp;
    }
    
    // 올바른 괄호 check 
    public static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}