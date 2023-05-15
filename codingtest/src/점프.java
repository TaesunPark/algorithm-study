import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int value = map[i][j];
                if (i == n-1 && j == n-1) continue;
                if (dp[i][j] == 0) continue;

                if (i + value < n){
                    dp[i+value][j] += dp[i][j];
                }

                if (j + value < n){
                    dp[i][j+value] += dp[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.print(dp[n-1][n-1]);
    }

}
