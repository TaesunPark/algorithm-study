import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5557 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][21];
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 0; i < N - 1; i++){
            for (int j = 0; j <= 20; j++) {
                long value = dp[i][j]; // 8
                if (value == 0) continue;
                if (j - arr[i + 1] >= 0 && j - arr[i + 1] <= 20) {
                    dp[i + 1][j - arr[i + 1]] += dp[i][j];
                }

                if (j + arr[i + 1] >= 0 && j + arr[i + 1] <= 20) {
                    dp[i + 1][j + arr[i + 1]] += dp[i][j];
                }
            }

        }

        System.out.print(dp[N-2][arr[N-1]]);


    }
}
