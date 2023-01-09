package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ12100 {
    public static int[] arr;
    public static int n;
    public static int[][] board1;
    public static int[][] board2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board1 = new int[21][21];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board1[i][j] = sc.nextInt();
            }
        }
    }

    public static void tilt(int dir){
        while (dir-- >= 0) {
            rotate();
        }
        for (int i = 0; i < n; i++){
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++){
                if (board2[i][j] == 0) continue;
                if (tilted[idx] == 0){
                    tilted[idx] = board2[i][j];
                }
            }
        }
    }

    public static void rotate(){
        int[][] tmp = new int[21][21];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tmp[i][j] = board2[i][j];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board2[i][j] = tmp[n-1-j][i];
            }
        }
    }


}
