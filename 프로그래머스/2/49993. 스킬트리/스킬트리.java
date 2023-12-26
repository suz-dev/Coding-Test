import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        ArrayList<Character> s_list = new ArrayList<>();
        
        // HashMap (선행 문자 정보)
        Map<Character, ArrayList<Character>> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            if(skill.length() == 1) break;
            
            char ch = skill.charAt(i);
            
            if(!s_list.isEmpty()) {
                ArrayList<Character> tmp = new ArrayList<>(s_list); // 복사
                map.put(ch, tmp);
            }
            
            s_list.add(ch);
        }
        
        // 문자열 검사
        for(String s : skill_trees){
            boolean[] arr = new boolean[26];
            
            out: for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                
                arr[ch - 'A'] = true;
                ArrayList<Character> tmp = new ArrayList<>();
                
                if(map.get(ch) != null) tmp = map.get(ch);

                for(Character c : tmp){ // 부적합 문자열
                    if(!arr[c - 'A']) {
                        answer--;
                        break out;
                    }
                }
            }
        }
        
        return answer;
    }
}