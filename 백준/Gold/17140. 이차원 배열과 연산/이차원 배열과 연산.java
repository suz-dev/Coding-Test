import java.io.*;
import java.util.*;

public class Main {
    static int R,C,K, time = 0;
    static int row, col;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());   // map[R][C] == K -> 종료 조건

        row = 3;
        col = 3;

        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < col; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while(map[R][C] != K){
            if(time > 100) {
                time = -1;
                break;
            }

            if(row >= col) operationR();
            else operationC();

            time++;
        }

        System.out.println(time);
    }

    // r 연산
    public static void operationR(){
        // 각 행에 대한 연산 수행
        // HashMap 으로 요소 개수 세기
        HashMap<Integer, Integer> hashMap;

        // 1. 개수 내림차순 / 2. 숫자 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }));

        for (int r = 0; r < row; r++){
            hashMap = new HashMap<>();
            for(int c = 0; c < col; c++){
                if(map[r][c] == 0) continue;    // 0 은 건너뜀

                hashMap.put(map[r][c], hashMap.getOrDefault(map[r][c], 0) + 1);
                map[r][c] = 0; // 초기화
            }

            // pq로 정렬
            for(int key : hashMap.keySet()){
                pq.add(new int[]{key, hashMap.get(key)});
            }

            // map 갱신
            int idx = 0;
            while(!pq.isEmpty() && idx < 99){ // size가 100을 넘을 수 없음
                int[] tmp = pq.poll();

                map[r][idx] = tmp[0]; // 숫자
                map[r][idx+1] = tmp[1]; // 개수

                idx += 2;
            }

            // col 갱신
            col = Math.max(col, idx);
        }
    }

    // c 연산
    public static void operationC(){
        // 각 열에 대한 연산 수행
        // HashMap 으로 요소 개수 세기
        HashMap<Integer, Integer> hashMap;

        // 1. 개수 내림차순 / 2. 숫자 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }));

        for (int c = 0; c < col; c++){
            hashMap = new HashMap<>();
            for(int r = 0; r < row; r++){
                if(map[r][c] == 0) continue;    // 0 은 건너뜀

                hashMap.put(map[r][c], hashMap.getOrDefault(map[r][c], 0) + 1);
                map[r][c] = 0; // 초기화
            }

            // pq로 정렬
            for(int key : hashMap.keySet()){
                pq.add(new int[]{key, hashMap.get(key)});
            }

            // map 갱신
            int idx = 0;
            while(!pq.isEmpty() && idx < 99){ // size가 100을 넘을 수 없음
                int[] tmp = pq.poll();

                map[idx][c] = tmp[0]; // 숫자
                map[idx+1][c] = tmp[1]; // 개수

                idx += 2;
            }

            // row 갱신
            row = Math.max(row, idx);
        }
    }
}