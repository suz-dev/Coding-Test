import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        boolean flag = false;

        while(T-- > 0){
            Map<Character, ArrayList<String>> hashMap = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            flag = true;
            while(n-- > 0){
                String num = br.readLine();
                char ch = num.charAt(0);

                ArrayList<String> list = hashMap.getOrDefault(ch, new ArrayList<>());
                for(String str : list){
                    String tmp = "";

                    if(str.length() > num.length()){
                        tmp = str.substring(0, num.length());
                        if(tmp.equals(num)) {
                            flag = false;
                            break;
                        }
                    }else{
                        tmp = num.substring(0, str.length());
                        if(tmp.equals(str)) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    list.add(num);
                    hashMap.put(ch, list);
                }
            }

            if(flag)bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}