import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp 문제
public class _1_2_3_더하기_4 {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 3 입력

        long[][] dp = new long[10001][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++){
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        for (int i = 0; i < n; i++){
            int value = Integer.parseInt(br.readLine());
            System.out.println(dp[value][1] + dp[value][2] + dp[value][3]);
        }
    }
}
