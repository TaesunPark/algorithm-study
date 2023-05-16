import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11058 {
    public static void main(String[] args) throws IOException {
        int N;
        long result = 0;
        long[] dp = new long[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;

        for (int i = 6; i <= 100; i++){
            dp[i] = dp[i-1] + 1;
            for (int j = 3; j <=i; j++){
                dp[i] = Math.max(dp[i], (j-1)*dp[i-j]);
            }
        }

        System.out.print(dp[N]);


    }
}
