package 바킹독.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.print(dp[n]);
        // n = 1, 1
        // n = 2, 2
        // n = 3, 1 + 1 + 1

    }
}
