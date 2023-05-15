package 바킹독.백트레킹;

import java.util.Scanner;

public class 소문난_칠공주 {
    static char[][] map;
    static int result;
    static int[] cnt_list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] mx;
    static int[] my;
    static boolean[][] check;

    public static void main(String[] args) {
        map = new char[5][5];
        result = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            String input = sc.nextLine();
            for (int j = 0; j < 5; j++){
                map[i][j] = input.charAt(j);
            }
        }

        comb(0, 0);

        System.out.print(result);
    }

    public static void comb(int depth, int pick_cnt){
        if (pick_cnt == 7){
            dfs();
        }

        if (depth == 25) return;

        comb(depth + 1, pick_cnt + 1);
        comb(depth + 1, pick_cnt);
    }

    public static void dfs(){

    }
}
