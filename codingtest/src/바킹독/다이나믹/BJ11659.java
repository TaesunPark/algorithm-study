package 바킹독.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] dp = new long[100001];

        st = new StringTokenizer(br.readLine());
        dp[0] = 0;
        dp[1] = Long.parseLong(st.nextToken());

        for (int i = 2; i <= N; i++){
            dp[i] += Long.parseLong(st.nextToken()) + dp[i - 1];
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(dp[b] - dp[a-1]);

        }


    }
}
