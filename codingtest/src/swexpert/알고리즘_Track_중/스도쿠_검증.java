package swexpert;

import java.util.Scanner;

public class 스도쿠_검증 {
    static int T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t_case = 1; t_case <= T; t_case++) {
            int[][] map = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            if (check(map) == false) {
                System.out.println("#" + t_case + " " + "0");
                continue;
            }
//            printMap(map);
//            System.out.println("");
            map = rotate(map);
//            printMap(map);

            if (check(map) == false) {
                System.out.println("#" + t_case + " " + "0");
                continue;
            }
            boolean check2 = true;
            for (int i = 0; i < 9; i+=3){
                for (int j = 0; j < 9; j += 3){
                    if (sum(i,j, map) != 45){
                        check2 = false;
                        break;
                    }
                }
                if (check2 == false){
                    break;
                }
            }
            if (check2 == false){
//                System.out.println("33");
                System.out.println("#" + t_case + " " + "0");
                continue;
            }
            System.out.println("#" + t_case + " " + "1");
        }
    }

    public static int sum(int x, int y, int[][] map){
        int s = 0;
        for (int i = y; i < y + 3; i++){
            for (int j = x; j < x + 3; j++){
                s += map[i][j];
            }
        }
        return s;
    }

    public static void printMap(int[][] map){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] rotate(int[][] map){
        int[][] tmp = new int[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                tmp[i][j] = map[8-j][i];
            }
        }
        return tmp;
    }

    public static boolean check(int[][] map){
        for (int i = 0; i < 9; i++){
            int sum = 0;

            for (int j = 0; j < 9; j++){
                sum += map[i][j];
            }

            if (sum != 45){
                return false;
            }
        }
        return true;
    }
}
