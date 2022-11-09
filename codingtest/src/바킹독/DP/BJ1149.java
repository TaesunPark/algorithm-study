package 바킹독.DP;

import java.util.Scanner;

public class BJ1149 {
    public static int dp[][];
    public static int map[][];

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n][3];
        map = new int[n][3];

        for(int i = 0; i < n; i++){
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        for (int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));

    }
}
