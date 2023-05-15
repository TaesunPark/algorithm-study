package 바킹독.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1149{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][4];
        // R 0
        // G 1
        // B 2
        int[][] dp = new int[1002][4];
        StringTokenizer st;

        for (int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 1002; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    if (j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + map[i][j]);
                }
            }
        }

        System.out.print(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }

}
