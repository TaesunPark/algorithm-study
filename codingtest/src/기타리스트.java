import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트 {
    public static void main(String[] args) throws IOException {
        int N, S, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        dp[0][S] = 1;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= M; j++){
                if (dp[i][j] == 1){
                    if (j - value >= 0){
                        dp[i + 1][j - value] = 1;
                    }
                    if (j + value <= M){
                        dp[i + 1][j + value] = 1;
                    }
                }
            }
        }

        for (int i = M; i >= 0; i--){
            if (dp[N][i] == 1){
                System.out.print(i);
                return;
            }
        }

        System.out.print("-1");
    }
}
