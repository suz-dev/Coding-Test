package 프로그래머스.카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    static int n, r;

    static String[] user_arr;
    static String[] banned_arr;

    static String[] arr;
    static boolean[] isSelected;

    static Set<ArrayList> set;

    public int solution(String[] user_id, String[] banned_id) {

        n = user_id.length;
        r = banned_id.length;

        arr = new String[r];
        isSelected = new boolean[n+1];    // 문자열 검사

        user_arr = user_id;
        banned_arr = banned_id;

        set = new HashSet<>();
        permutation(0);

        return set.size();
    }

    // 순열 생성
    private static void permutation(int cnt){
        if(cnt == r){
            boolean flag = true;
            for(int i = 0; i < r; i++){
                if(flag && !checkBannedId(arr[i], banned_arr[i])){  // 유효성 검사
                    return;
                }
            }

            // 배열 복사 (원본배열로 하면 순열생성에 문제생김)
            String[] arr2 = new String[arr.length];
            for(int i = 0;i < r; i++){
                arr2[i] = arr[i];
            }

            // 중복 제거
            Arrays.sort(arr2);
            set.add(new ArrayList<>(Arrays.asList(arr2)));

            return;
        }

        for(int i = 0; i < n; i++){
            if(!isSelected[i]){
                arr[cnt] = user_arr[i];

                isSelected[i] = true;
                permutation(cnt+1);
                isSelected[i] = false;
            }
        }
    }

    // 문자열 비교
    private static boolean checkBannedId(String user_id, String banned_id){
        if(user_id.length() != banned_id.length()){
            return false;
        }

        for(int i = 0 ;i < user_id.length(); i++){
            if(banned_id.charAt(i)!='*'&& user_id.charAt(i) != banned_id.charAt(i)){
                return false;
            }
        }
        return true;
    }
}