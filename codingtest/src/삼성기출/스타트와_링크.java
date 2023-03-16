package 삼성기출;

import java.util.Scanner;

public class 스타트와_링크 {
    static int n;
    static int[][] map;
    static boolean[] check;
    static int gap;
    static int aV;
    static int bV;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        check = new boolean[n];
        gap = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.print(gap);
    }

    public static void dfs(int depth, int st){

        if (depth == n / 2){

            int[] a_list = new int[depth];
            int[] b_list = new int[depth];

            int idxA=0, idxB = 0;
            int value;
            aV = 0;
            boolean[] check2 = new boolean[depth];

            for (int i = 0; i < n; i++){
                if (check[i] == true){
                    a_list[idxA++] = i;
                } else{
                    b_list[idxB++] = i;
                }
            }
            // 123 조합 1,2 1,3 2,3
            comb(a_list, check2, 0, 0);
            value = aV;
            aV = 0;
            comb(b_list, check2, 0, 0);
            value -= aV;
            gap = Math.min(gap, Math.abs(value));
            return;
        }

        for (int i = st; i < n; i++){
            if (check[i] == true) continue;
            check[i] = true;
            dfs(depth + 1, i + 1);
            check[i] = false;
        }

    }

    public static void comb(int[] list, boolean[] check2, int depth, int st){
        if (depth == 2){
            int v1 = 0, v2 = 0;
            for (int i = 0; i < check2.length; i++){
                if (check2[i] == true){
                    if (v1 == 0){
                        v1 = list[i];
                    } else{
                        v2 = list[i];
                    }
                }
            }

            aV += map[v1][v2];
            aV += map[v2][v1];
            return ;
        }

        for(int i = st; i < list.length; i++){
            if (check2[i] == true) continue;
            check2[i] = true;
            comb(list, check2, depth + 1, i + 1);
            check2[i] = false;
        }

    }

}
