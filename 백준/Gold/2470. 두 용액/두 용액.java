import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num < 0) arr[i] = new Node(num * (-1), -1);
            else arr[i] = new Node(num , 1);
        }

        int sum = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1.num));
        for(int i = 0 ;i < N - 1; i++){
            Node node1 = arr[i];
            Node node2 = arr[i+1];

            int tmp = 0;
            if(node1.stand == node2.stand) tmp = node1.num + node2.num;
            else tmp = node2.num - node1.num;

            if(tmp < sum){
                sum = tmp;
                ans1 = node1.num * node1.stand;
                ans2 = node2.num * node2.stand;
            }
        }

        if(ans1 < ans2) System.out.println(ans1 + " " + ans2);
        else System.out.println(ans2 + " " + ans1);
    }

    static class Node{
        int num, stand;

        public Node(int num, int stand) {
            this.num = num;
            this.stand = stand;
        }
    }
}