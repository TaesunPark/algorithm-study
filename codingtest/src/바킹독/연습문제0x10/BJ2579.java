package 바킹독.연습문제0x10;

import java.util.Scanner;

public class BJ2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] point = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i<=n; i++){
            point[i] = sc.nextInt();
        }

        dp[1] = point[1];
        dp[2] = point[1]+point[2];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+point[i-1]) + point[i];
        }

        System.out.println(dp[n]);
    }
}
