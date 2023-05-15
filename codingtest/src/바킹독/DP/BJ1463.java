package 바킹독.DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1463 {
    public static void main(String[] args) {
        int[] dp;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n; i >= 1; i--){
            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);

            if (i % 3 == 0){
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }

            if (i % 2 == 0){
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
        }

        System.out.print(dp[1]);



    }
}
