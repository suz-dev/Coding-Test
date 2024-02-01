import java.io.*;
import java.util.*;

public class Main {
    static String S, T;
    static Map<Character, Queue<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        map = new HashMap<>();
        for(int i = 0; i< S.length(); i++){
            char ch = S.charAt(i);

            Queue<Integer> tmp = map.getOrDefault(ch, new LinkedList<>());
            tmp.add(i);
            map.put(ch, tmp);
        }

        int cnt = 0;
        out: while(true){
            int preIdx = -1;

            for(int i = 0; i < T.length(); i++){
                char key = T.charAt(i);
                Queue<Integer> val = map.getOrDefault(key, new LinkedList<>());

                if(val.isEmpty()) {
                    break out;
                }

                int nowIdx = val.poll();

                while(nowIdx < preIdx ){
                    if(val.isEmpty()){
                        break out;
                    }
                    nowIdx = val.poll();
                }

                preIdx = nowIdx;
                map.put(key, val);
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}