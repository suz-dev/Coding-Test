import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] isSelected;
    static int[] player;
    static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n][10];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[10];
        player = new int[10];

        // 1번 선수는 반드시 4번 타자
        isSelected[4] = true;
        player[4] = 1;

        permutation(2);

        System.out.println(result);
    }

    // 순열
    private static void permutation(int cnt) {
        if (cnt == 10)
            play();

        for (int i = 1; i <= 9; i++) {
            if (!isSelected[i]) {
                player[i] = cnt;

                isSelected[i] = true;
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    // 조합별 점수 구하기
    private static void play() {
        int score = 0;
        int startPlayer = 1;    // 시작 타자
        boolean[] base; // 베이스 현황

        for (int i = 0; i < n; i++) {
            int outCnt = 0;
            base = new boolean[4]; 

            finish:
            while (true) {
                for (int j = startPlayer; j <= 9; j++) {
                    int hitter = arr[i][player[j]]; // 타자

                    switch (hitter) {
                        case 0: //아웃
                            outCnt++;
                            break;
                            
                        case 1: //1루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }

                                    base[k] = false;
                                    base[k + 1] = true;
                                }
                            }
                            base[1] = true;
                            break;
                            
                        case 2: //2루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3 || k == 2) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                            base[2] = true;
                            break;
                            
                        case 3: //3루타
                            for (int k = 1; k <= 3; k++) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            base[3] = true;
                            break;
                            
                        case 4: //홈런
                            for (int k = 1; k <= 3; k++) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break;
                    }

                    if (outCnt == 3) {
                        startPlayer = j + 1;
                        if (startPlayer == 10) {   
                            startPlayer = 1;
                        }
                        break finish;
                    }
                }

                startPlayer = 1;    // 1번부터 다시
            }
        }

        result = Math.max(result, score);   // 최대값 갱신
    }
}