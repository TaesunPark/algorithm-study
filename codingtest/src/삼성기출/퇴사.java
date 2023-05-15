package 삼성기출;

import java.util.Scanner;

public class 퇴사 {
    static int N;
    static int[][] data;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N + 1][2];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++){
            if (i + data[i][0] <= N) {
                dp[i + data[i][0]] = Math.max(dp[i + data[i][0]], dp[i] + data[i][1]);
            }

            dp[i + 1] = Math.max(dp[i+1], dp[i]);
        }
    }
}
