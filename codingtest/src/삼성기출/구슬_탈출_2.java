package 삼성기출;

import java.util.Scanner;

public class 구슬_탈출_2 {

    static char[][] map;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로
        m = sc.nextInt(); // 가로

        map = new char[n][n];

        for (int i = 0; i < n; i++){
            String str = sc.nextLine();
            for (int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        

    }
}
