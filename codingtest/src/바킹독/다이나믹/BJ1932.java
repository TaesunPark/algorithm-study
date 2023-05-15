package 바킹독.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1932 {
    public static void main(String[] args) throws IOException {
        int N;
        int[][] map;
        int[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int k = 0;
            for (int j = N - i; j <= N; j++){
                map[i][k] = Integer.parseInt(st.nextToken());
                k++;
            }
        }

        dp[0][0] = map[0][0];
        dp[1][0] = map[1][0] + dp[0][0];
        dp[1][1] = map[1][1] + dp[0][0];

        for (int i = 2; i < N; i++){
            for (int j = 0; j < i; j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + map[i][j];
                } else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + map[i][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + map[i][j];
                }
            }
        }

        Arrays.sort(dp[N - 1]);
        System.out.print(dp[N-1][N - 1]);

    }
}
