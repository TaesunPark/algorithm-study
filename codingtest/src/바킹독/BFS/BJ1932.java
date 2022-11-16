package 바킹독.BFS;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1932 {
    static int n;
    static int[][] dp;
    static int[][] map;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                map[i][j] = sc.nextInt();
            }
        }

        if(n == 1){
            System.out.print(map[0][0]);
            return;
        } else{
            dp[1][0] = map[0][0] + map[1][0];
            dp[1][1] = map[0][0] + map[1][1];
        }

        for (int i = 2; i < n; i++){
            for (int j = 0; j < n; j++){

                if (j == 0){
                    dp[i][j] = map[i][j] + dp[i-1][j];
                } else if(j == i){
                    dp[i][j] = map[i][j] + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
                }
            }
        }

        Arrays.sort(dp[n-1]);
        System.out.print(dp[n - 1][n - 1]);



    }


}
