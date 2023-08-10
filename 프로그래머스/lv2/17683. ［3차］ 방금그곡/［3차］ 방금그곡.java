import java.util.*;
import java.io.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);
        int max = 0; // 최장재생시간
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            String title = str[2]; // 음악제목
            String music = convert(str[3]); // 악보
            String[] start = str[0].split(":"); // 시작시간
            String[] end = str[1].split(":"); // 종료시간
            
            int hour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
            int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            int time = hour + minute;
            
            StringBuilder sb = new StringBuilder(); // 재싱시간동안 재생된 전체멜로디
            for (int j = 0; j < time; j++) { // 전체멜로디 만들기
                sb.append(music.charAt(j % music.length()));
            }
            
            if (sb.toString().contains(m)) { 
                if (max < sb.toString().length()) { 
                    max = sb.toString().length();
                    answer = title;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    // 두글자(음표#) 한글자로 치환
    private String convert(String m) {
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        return m;
    }
}