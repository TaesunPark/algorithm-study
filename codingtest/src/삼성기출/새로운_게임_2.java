package 삼성기출;

import java.util.Scanner;

public class 새로운_게임_2 {
    static int[][] map;
    static boolean[][] check;
    static int N,M,T;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1, 0, 1, 0};
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        map = new int[N][M];
        check = new boolean[N][M];
        // 1 1 2 3 북 동 남 서
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while (T > 0){
            // 배수
            int xi = sc.nextInt();
            // 방향 0은 시계, 1은 반시계;
            int di = sc.nextInt();
            // 몇 번 회전할 건지
            int ki = sc.nextInt() % M;
            printMap();
            rotate(xi, di, ki); // ok
            printMap();
            // 원판에 수가 남아 있으면, 인접하면서 수가 같은 것을 모두 찾는다.
            find();
            T--;
        }

        int sum = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (check[i][j] == true) continue;
                sum += map[i][j];
            }
        }

        System.out.print(sum);
    }

    public static void printMap(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void find(){
        boolean checked = false;
        double cnt = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M - 1; j++){
                if (map[i][j] != 1001 && map[i][j] == map[i][j + 1]){
                    check[i][j] = true;
                    check[i][j + 1] = true;
                    checked = true;
                    cnt += 1;
                }
                if ( i + 1 < N && map[i][j] != 1001 && map[i][j] == map[i+1][j]){
                    check[i][j] = true;
                    check[i+1][j] = true;
                    checked = true;
                    cnt += 1;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (check[i][j] == true){
                    map[i][j] = 1001;
                }
            }
        }

        if (checked == false){
            double avr = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1001) continue;
                    avr += (double) map[i][j];
                }
            }
            avr /= cnt;

            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1001) continue;
                    if (map[i][j] < avr){
                        map[i][j]++;
                    }
                    if (map[i][j] > avr){
                        map[i][j]--;
                    }
                }
            }

        }

    }
    // 2 0 1
    public static void rotate(int xi, int di, int ki){
        int idx = xi;

        while (idx-1 < N){
            if (di == 1) {
                for (int k = 0; k < ki; k++) {
                    int[] tmpArr = new int[M];
                    boolean[] checked = new boolean[M];

                    for (int i = 0; i < M; i++) {
                        tmpArr[i] = map[idx - 1][i];
                        checked[i] = check[idx - 1][i];
                    }
                    // 반시계방향
                    for (int i = 1; i < M; i++){
                        map[idx-1][i-1] = tmpArr[i];
                        check[idx-1][i-1] = checked[i];
                    }

                    map[idx - 1][M - 1] = tmpArr[0];
                    check[idx - 1][M - 1] = checked[0];
                }
            } else {
                for (int k = 0; k < ki; k++) {
                    int[] tmpArr = new int[M];
                    boolean[] checked = new boolean[M];

                    for (int i = 0; i < M; i++) {
                        tmpArr[i] = map[idx - 1][i];
                        checked[i] = check[idx - 1][i];
                    }
                    // 시계방향
                    for (int i = 1; i < M; i++) {
                        map[idx - 1][i] = tmpArr[i - 1];
                        check[idx - 1][i] = checked[i - 1];
                    }
                    map[idx - 1][0] = tmpArr[M - 1];
                    check[idx - 1][0] = checked[M - 1];
                }
            }

            idx *= 2;
        }
    }
}