package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ14500 {
    public static int[][] map;
    public static int N;
    public static int M;
    public static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        start();
        leftRotate();
        rotate();
        start();
        rotate();
        start();
        rotate();
        start();
        rotate();
        leftRotate();

        topRotate();
        rotate();
        start();
        rotate();
        start();
        rotate();
        start();
        rotate();
        topRotate();
        rotate();
        start();
        rotate();
        start();
        rotate();
        start();

        System.out.print(max);
    }

    public static void start(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                max = Math.max(v1(j,i), max);
                max = Math.max(v2(j,i), max);
                max = Math.max(v3(j,i), max);
                max = Math.max(v4(j,i), max);
                max = Math.max(v5(j,i), max);
            }
        }
    }

    // 90도 회전
    public static void rotate(){
        int[][] tmpMap = new int[N][M];
        int[][] tmp2 = new int[M][N];
        tmpMap = copy(map);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                tmp2[j][i] = tmpMap[N-i-1][j];
            }
        }

        int tmp = N;
        N = M;
        M = tmp;
        map = tmp2;
    }

    // 좌우 대칭
    public static void leftRotate(){
        int[][] tmpMap = new int[N][M];
        tmpMap = copy(map);

        for (int i = 0; i < N; i++){
            int idx = 0;
            for (int j = M - 1; j >= 0; j--){
                map[i][idx++] = tmpMap[i][j];
            }
        }
    }

    // 상하 대칭
    public static void topRotate(){
        int[][] tmpMap = new int[N][M];
        tmpMap = copy(map);
        int idx = 0;

        for (int i = N - 1; i >= 0; i--){
            for (int j = 0; j < M; j++){
                map[idx][j] = tmpMap[i][j];
            }
            idx++;
        }
    }
    
    public static int[][] copy(int[][] tet){
        int[][] tmp = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                tmp[i][j] = tet[i][j];
            }
        }

        return tmp;
    }

    public static int v1(int x, int y){
        if (y < 0 || y >= N || x < 0 || x + 3 >= M){
            return 0;
        }

        int p1 = map[y][x];
        int p2 = map[y][x + 1];
        int p3 = map[y][x + 2];
        int p4 = map[y][x + 3];
        return p1 + p2 + p3 + p4;
    }

    public static int v2(int x, int y){
        if (y < 0 || y + 1 >= N || x < 0 || x + 1 >= M){
            return 0;
        }

        int p1 = map[y][x];
        int p2 = map[y][x + 1];
        int p3 = map[y + 1][x];
        int p4 = map[y + 1][x + 1];
        return p1 + p2 + p3 + p4;
    }

    public static int v3(int x, int y){
        if (y < 0 || y + 2 >= N || x < 0 || x + 1 >= M){
            return 0;
        }

        int p1 = map[y][x];
        int p2 = map[y + 1][x];
        int p3 = map[y + 2][x];
        int p4 = map[y + 2][x + 1];
        return p1 + p2 + p3 + p4;
    }

    public static int v4(int x, int y){
        if (y < 0 || y + 2 >= N || x < 0 || x + 1 >= M){
            return 0;
        }

        int p1 = map[y][x];
        int p2 = map[y + 1][x];
        int p3 = map[y + 1][x + 1];
        int p4 = map[y + 2][x + 1];
        return p1 + p2 + p3 + p4;
    }

    public static int v5(int x, int y){
        if (y < 0 || y + 1 >= N || x < 0 || x + 2 >= M){
            return 0;
        }

        int p1 = map[y][x];
        int p2 = map[y][x + 1];
        int p3 = map[y + 1][x + 1];
        int p4 = map[y][x + 2];
        return p1 + p2 + p3 + p4;
    }
}
