import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 배열돌리기4
public class Main {
    static int N, M, K;
    static int[][] map, rotationInfo;
    static int[] arr;
    static boolean[] isSelected;
    static ArrayList<int[]> permList = new ArrayList<>();

    public static int solution(){
        int answer = Integer.MAX_VALUE;

        arr = new int[K];
        isSelected = new boolean[K];

        permutation(0);

        // 배열 돌리기
        for(int[] perm : permList){
            int[][] tmpMap = arrRotation(perm);
            answer = Math.min(answer, calMin(tmpMap));
        }

        return answer;
    }

    // 배열돌리기
    static int[][] arrRotation(int[] perm){
        // 회전할 배열
        int[][] newMap = new int[N + 2][M + 2];
        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= M; c++){
                newMap[r][c] = map[r][c];
            }
        }

        for(int k = 0; k < K; k++){
            int[] now = rotationInfo[perm[k]];
            int r = now[0];
            int c = now[1];
            int s = now[2];

            while(s > 0){
                int startR = r - s;
                int endR = r + s;
                int startC = c - s;
                int endC = c + s;

                int a = newMap[startR][startC];

                for(int i = startR; i < endR; i++) newMap[i][startC] = newMap[i + 1][startC];
                for(int j = startC; j < endC; j++) newMap[endR][j] = newMap[endR][j + 1];
                for(int i = endR; i > startR; i--) newMap[i][endC] = newMap[i - 1][endC];
                for(int j = endC; j > startC; j--) newMap[startR][j] = newMap[startR][j - 1];

                newMap[startR][startC + 1] = a;

                s--;
            }
        }

        return newMap;
    }

    // 최소값 계산
    static int calMin(int[][] newMap){
        int min = Integer.MAX_VALUE;

        for(int r = 1; r <= N; r++){
            int sum = 0;
            for(int c = 1; c <= M; c++){
                sum += newMap[r][c];
            }

            min = Math.min(min, sum);
        }
        return min;
    }

    // 순열
    static void permutation(int cnt){
        if(cnt == K){
            int[] nArr = Arrays.copyOf(arr, K);
            permList.add(nArr);
            return;
        }

        for(int i = 0; i < K; i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            arr[cnt] = i;

            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        rotationInfo = new int[K][3];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            rotationInfo[i][0] = Integer.parseInt(st.nextToken());
            rotationInfo[i][1] = Integer.parseInt(st.nextToken());
            rotationInfo[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
}