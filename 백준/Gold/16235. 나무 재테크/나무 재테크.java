import java.util.*;
import java.io.*;

// 나무재테크
public class Main {
    static int N, M, K;
    static int[][] A;
    static int[][] map;
    static Deque<Tree> treeInfo;
    static int[][] drc = {{0,0,1,-1,1,1,-1,-1}, {1,-1,0,0,1,-1,1,-1}};  // 8방 탐색

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   // 산 나무 수
        K = Integer.parseInt(st.nextToken());

        // 초기 땅 상태
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], 5);
        }

        // 겨울에 추가되는 양분
        A = new int[N][N];
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 나무 정보 (나무 나이 오름차순)
        treeInfo = new LinkedList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            Tree tree = new Tree(r, c, age);
            treeInfo.add(tree);
        }

        while(K-- > 0){
            Queue<Tree> nowTrees = new LinkedList<>();
            Queue<Tree> deadTrees = new LinkedList<>();

            // 봄 - 양분 섭취
            while (!treeInfo.isEmpty()){
                Tree now = treeInfo.poll();
                if(map[now.r][now.c] < now.age) deadTrees.add(now);
                else {
                    map[now.r][now.c] -= now.age;
                    now.age++;
                    nowTrees.add(now);
                }
            }

            // 여름 - 죽은 나무 -> 양분
            while(!deadTrees.isEmpty()){
                Tree now = deadTrees.poll();
                map[now.r][now.c] += (now.age / 2);
            }
            
            // 가을 - 나무 번식
            while(!nowTrees.isEmpty()){
                // 번식 대상 나무
                Tree now = nowTrees.poll();
                treeInfo.add(now);

                // 번식 대상 아님
                if(now.age % 5 != 0) continue;

                for(int d = 0; d < 8; d++){
                    int nr = now.r + drc[0][d];
                    int nc = now.c + drc[1][d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    treeInfo.addFirst(new Tree(nr, nc, 1));
                }
            }

            // 겨울 - 양분 추가
            for (int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    map[r][c] += A[r][c];
                }
            }
        }

        System.out.println(treeInfo.size());
    }

    static class Tree{
        int r, c, age;

        public Tree(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
}