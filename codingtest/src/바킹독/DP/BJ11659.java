package 바킹독.DP;

import java.util.Scanner;

public class BJ11659 {
    public static void main(String[] args) {
        int n,m;
        int[] arr;
        int[] dp;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];
        dp  = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < m; i++){
            int idx1 = sc.nextInt() - 1;
            int idx2 = sc.nextInt();
            System.out.println(dp[idx2] - dp[idx1]);
        }

    }
}
