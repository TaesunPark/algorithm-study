package 바킹독.다이나믹;


import java.util.Arrays;
import java.util.Scanner;

public class BJ1463 {
    public static int X;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();

        dp = new int[X + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[X] = 0;

        for (int i = X; i >= 1; i--){
            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
            if (i % 2 == 0){
                dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);
            }
            if (i % 3 == 0){
                dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);
            }
        }

        System.out.print(dp[1]);
    }
}
