package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ14499 {
    static int N;
    static int M;
    static int x;
    static int y;
    static int k;

    static int[][] dice;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        k = sc.nextInt();

        map = new int[N][M];
        dice = new int[4][3];
        int cnt = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++){
            int cmd = sc.nextInt();

            printMap();

            switch (cmd){
                case 1:
                    east();
                    break;
                case 2:
                    west();
                    break;
                case 3:
                    north();
                    break;
                case 4:
                    south();
                    break;
            }

        }
    }

    public static void printMap(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(dice[i][j]);
            }
            System.out.println("");
        }
    }
    public static void south(){

        if (y + 1 >= N){
            return;
        }

        y = y + 1;

        int[][] tmp_dice = new int[4][3];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                tmp_dice[i][j] = dice[i][j];
            }
        }

        dice[0][1] = tmp_dice[1][1];
        dice[1][1] = tmp_dice[2][1];
        dice[2][1] = tmp_dice[3][1];
        dice[3][1] = tmp_dice[0][1];

        if (map[y][x] == 0){
            map[y][x] = dice[1][1];
        } else{
            dice[1][1] = map[y][x];
            map[y][x] = 0;
        }

        System.out.println(dice[3][1]);
    }

    public static void north(){

        if (y - 1 < 0){
            return;
        }

        y = y - 1;

        int[][] tmp_dice = new int[4][3];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                tmp_dice[i][j] = dice[i][j];
            }
        }

        dice[0][1] = tmp_dice[3][1];
        dice[1][1] = tmp_dice[0][1];
        dice[2][1] = tmp_dice[1][1];
        dice[3][1] = tmp_dice[2][1];

        if (map[y][x] == 0){
            map[y][x] = dice[1][1];
        } else{
            dice[1][1] = map[y][x];
            map[y][x] = 0;
        }

        System.out.println(dice[3][1]);
    }
    public static void east(){

        if (x + 1 >= M){
            return;
        }

        x = x + 1;

        int[][] tmp_dice = new int[4][3];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                tmp_dice[i][j] = dice[i][j];
            }
        }

        dice[1][0] = tmp_dice[1][1];
        dice[1][1] = tmp_dice[1][2];
        dice[1][2] = tmp_dice[3][1];
        dice[3][1] = tmp_dice[1][0];

        if (map[y][x] == 0){
            map[y][x] = dice[1][1];
        } else{
            dice[1][1] = map[y][x];
            map[y][x] = 0;
        }

        System.out.println(dice[3][1]);
    }
    public static void west(){

        if (x - 1 < 0){
            return;
        }
        x = x - 1;

        int[][] tmp_dice = new int[4][3];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                tmp_dice[i][j] = dice[i][j];
            }
        }

        dice[1][1] = tmp_dice[1][0];
        dice[1][2] = tmp_dice[1][1];
        dice[1][0] = tmp_dice[3][1];
        dice[3][1] = tmp_dice[1][2];

        if (map[y][x] == 0){
            map[y][x] = dice[1][1];
        } else{
            dice[1][1] = map[y][x];
            map[y][x] = 0;
        }

        System.out.println(dice[3][1]);
    }
}
