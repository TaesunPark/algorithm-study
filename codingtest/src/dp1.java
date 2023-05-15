import java.util.Scanner;

public class dp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        // 6 10 13 9 8 1
        // 3잔 연속 x
        // xoo dp[i-3] +
        // oxo
        //
        dp[1] = arr[1];
        dp[2] = Math.max(dp[1], dp[1] + arr[2]);

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + arr[i];
            dp[i] = Math.max(dp[i-3] + dp[i - 1] + arr[i], dp[i-2] + arr[i]);
        }


        System.out.print(dp[n]);
    }
}
