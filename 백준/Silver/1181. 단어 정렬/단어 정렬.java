import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        ArrayList<Node> list = new ArrayList<>();

        while(N-- > 0){
            String str = br.readLine();
            set.add(str);
        }
        
        for(String str : set){
            int len = str.length();
            Node node = new Node(str, len);
            list.add(node);
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.len == o2.len) return o1.str.compareTo(o2.str);
            return o1.len - o2.len;
        });

        for(Node node : list){
            System.out.println(node.str);
        }
    }

    public static class Node{
        String str;
        int len;

        public Node(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }
}