package 바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++){
            dp[i] = dp[i-2] +dp[i-1];
        }

        int result = 1;
        int before = 0;

        for (int i = 0; i < M; i++){
            int vip = Integer.parseInt(br.readLine());
            result *= dp[vip - 1 - before];
            before = vip;
        }

        result *= dp[N - before];

        System.out.print(result);


    }
}
