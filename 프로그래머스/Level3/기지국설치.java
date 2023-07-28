package PRGRMS.level3;

import java.util.*;
import java.io.*;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 0;    // stations index
        int position = 1;

        while(position <= n) {
            if(idx < stations.length && position >= stations[idx] - w) {
                position = stations[idx] + w + 1;
                idx++;
            }else {
                answer++;
                position += (w*2) + 1;
            }
        }
        return answer;
    }
}
